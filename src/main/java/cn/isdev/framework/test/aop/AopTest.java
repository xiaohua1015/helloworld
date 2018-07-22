package cn.isdev.framework.test.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/7/22.
 */
public class AopTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/bean.xml");
//        IUserDao userDao = (IUserDao) context.getBean("userDao_proxy");
        IUserDao userDao = (IUserDao) context.getBean("userDao");
        userDao.save();
    }
}
