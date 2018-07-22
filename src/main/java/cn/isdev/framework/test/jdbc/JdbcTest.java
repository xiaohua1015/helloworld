package cn.isdev.framework.test.jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/7/22.
 */
public class JdbcTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/jdbc.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
        System.out.println(userDao.query());
    }
}
