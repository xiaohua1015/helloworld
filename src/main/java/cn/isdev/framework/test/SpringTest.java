package cn.isdev.framework.test;

import cn.isdev.framework.action.UserAction;
import cn.isdev.framework.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Administrator on 2018/7/21.
 */
public class SpringTest {

    public static void main(String[] args){
//        getBeanFromConfig();
//        constructor();
        IOCTest();
    }

    public static void IOCTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserAction userAction = (UserAction) context.getBean("userAction");
        userAction.save();
        context.close();
    }

    private static void constructor() {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userArgs = context.getBean("userArgs");
        System.out.println("userArgs = " + userArgs);
        context.close();
    }

    private static void getBeanFromConfig() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        System.out.println("USER = " + user);
        context.close();
    }
}
