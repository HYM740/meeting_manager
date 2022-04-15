package me.hym.meeting.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 封装Properties加载操作
 * @author bataneko
 */
public class PropertiesUtil {
    private PropertiesUtil(){}
    /**
     * 从指定的文件路径读取配置文件
     * @param path 文件路径
     * @return 已读取配置文件的Properties对象
     * @throws IOException 当发生IO错误
     */
    public static Properties getPropertiesFromFilePath(String path) throws IOException {
        Properties properties = null;
        if(path!=null&&!path.equals("")){
            InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
            properties = new Properties();
            properties.load(in);
        }
        return properties;
    }
}
