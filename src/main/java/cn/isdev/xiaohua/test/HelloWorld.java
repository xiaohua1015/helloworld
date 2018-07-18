package cn.isdev.xiaohua.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2018/7/14.
 */
public class HelloWorld {

    private static String name = "xiaohua";

    static {
        System.out.println("name = " + name);
    }

    public static void main(String[] args) {
//        jdbc();
//        collection();
        Log log = LogFactory.getLog(HelloWorld.class);
        log.debug("debug信息");
        log.info("info信息");
        log.warn("warn信息");
        log.error("error信息");
    }

    private static void collection() {
        try {
            List<String> set = new ArrayList<>();
            System.out.println(set.add("123"));
            System.out.println(set.add("123"));
            int a = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }finally {
            System.out.println("finally");
        }
    }

    private static void jdbc() {
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
