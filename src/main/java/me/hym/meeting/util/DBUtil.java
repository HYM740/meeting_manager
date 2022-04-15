package me.hym.meeting.util;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * JDBC操作封装工具类
 *
 * @author bataneko
 */
public class DBUtil {
    private static String driver = null;
    private static String username = null;
    private static String password = null;
    private static String datasource_url = null;
    private DBUtil(){}
    //从外部配置文件获取数据库连接配置
    static {
        try {
            Properties properties = PropertiesUtil.getPropertiesFromFilePath("jdbc.properties");
            driver = properties.getProperty("driver");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            datasource_url = properties.getProperty("datasource_url");
            Class.forName(driver);
        } catch (IOException e) {
            System.err.println("读取jdbc.properties时发生错误");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("加载数据库驱动时发生错误");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(datasource_url, username, password);
    }

    /**
     * 关闭并释放数据库资源
     * <br>
     * 忽略任何异常
     *
     * @param conn 要关闭的数据库连接
     * @param st   要关闭的Statement
     * @param rs   要关闭的结果集
     */
    public static void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
//            e.printStackTrace();
        }
    }

    /**
     * 通用查询操作
     * @param clazz 实体类
     * @param sql sql语句
     * @param args sql语句中的参数
     * @param <T> 实体类派生的对象
     * @return 查询到的对象集合
     */
    public static <T> List<T> commonsQuery(Class<T> clazz, String sql, Object ...args){
        List<T> tList =new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c = getConnection();
            ps = c.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                T t = (T)clazz.getConstructor().newInstance();
                for(int i=1;i<=rsmd.getColumnCount();i++){
                    Field f = clazz.getDeclaredField(rsmd.getColumnName(i).trim().toLowerCase());
                    f.setAccessible(true);
                    //对于Oracle数据库的number类型特殊处理
                    if(rs.getObject(i) instanceof BigDecimal){
                        BigDecimal bd = (BigDecimal) rs.getObject(i);
                        int value = bd.intValue();
                        f.set(t,value);
                        continue;
                    }
                    f.set(t,rs.getObject(i));
                }
                tList.add(t);
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                InvocationTargetException | NoSuchFieldException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return tList;
    }

    /**
     * 通用增删改操作
     * @param sql sql语句
     * @param args sql语句中的参数
     * @return 受影响的行数
     */
    public static int commonsUpdate(String sql,Object ...args){
        int effects=0;
        Connection c=null;
        PreparedStatement ps=null;
        try {
            c = getConnection();
            ps = c.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            effects=ps.executeUpdate();
            c.commit();
        } catch (SQLException throwables) {
            try {
                c.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            close(c,ps,null);
        }
        return effects;
    }
}
