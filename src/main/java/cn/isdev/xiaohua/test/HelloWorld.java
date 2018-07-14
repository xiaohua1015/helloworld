package cn.isdev.xiaohua.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2018/7/14.
 */
public class HelloWorld {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/test?characterEncoding=utf-8&useSSL=false";
        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            Properties prop = new Properties();
            prop.load(clazz.getResourceAsStream("/prop.properties"));
            Connection conn = DriverManager.getConnection(url, prop);
            System.out.println(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
