package cn.isdev.xiaohua.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2018/7/16.
 */
public class MyServletContentListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyServletContextListener.contextDestroyed()");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("1..........MyServletContextListener.contextInitialized()");
    }

}

