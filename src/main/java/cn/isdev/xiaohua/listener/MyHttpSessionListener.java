package cn.isdev.xiaohua.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 2018/7/16.
 */
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("MySessionListener.sessionCreated()");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("MySessionListener.sessionDestroyed()");
    }

}
