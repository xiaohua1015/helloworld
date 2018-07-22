package cn.isdev.framework.test.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/22.
 */
@Component
@Aspect
public class Aop {

    @Before("execution(* cn.isdev.framework.test.aop.UserDao.*(..))")
    public void begin() {
        System.out.println("开始事物");
    }

    @After("execution(* cn.isdev.framework.test.aop.UserDao.*(..))")
    public void end() {
        System.out.println("结束事物");
    }
}
