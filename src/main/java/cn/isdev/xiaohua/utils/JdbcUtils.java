package cn.isdev.xiaohua.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 2018/7/15.
 */
public class JdbcUtils {
    private static String url = null;
    private static Properties prop = null;

    static {
        prop = new Properties();
        InputStream resourceAsStream = JdbcUtils.class.getResourceAsStream("/prop.properties");
        try {
            prop.load(resourceAsStream);
            url = prop.getProperty("url");
            System.out.println("jdbc url = " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/test?characterEncoding=utf-8&useSSL=false", prop);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void clossAll(Connection conn, Statement st, ResultSet rs){
        try {
            if(conn != null) {
                conn.close();
            }
            if(st != null) {
                st.close();
            }
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
