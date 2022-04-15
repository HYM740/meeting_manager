package me.hym.util;

import me.hym.meeting.dao.EmployeeDao;
import me.hym.meeting.dao.impl.EmployeeDaoImpl;
import me.hym.meeting.util.DBUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库相关测试
 */
public class DBConnectionTest {
    /**
     * 数据库连通性测试
     */
    @Test
    void connectionTest() {
        Connection c=null;
        try {
            c = DBUtil.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Assertions.assertNotNull(c);
        DBUtil.close(c,null,null);
    }

    /**
     * 数据库读取测试
     */
    @Test
    void readTest() {
        EmployeeDao ed = new EmployeeDaoImpl();
        Assertions.assertTrue(ed.selectAll().size()!=0);
    }
}
