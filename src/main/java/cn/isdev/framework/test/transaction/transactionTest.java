package cn.isdev.framework.test.transaction;

import cn.isdev.framework.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/7/23.
 */
public class transactionTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/transaction.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.save(new User("杨杨1213", "654321"));
    }
}
