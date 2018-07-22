package cn.isdev.framework.test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/7/22.
 */
public class ProxyFactory {

    private static Object target;
    private static Aop aop;
    public static Object getProxyInstance(final Object target_, final Aop aop_){
        target = target_;
        aop = aop_;
        return  Proxy.newProxyInstance(target_.getClass().getClassLoader(),
                target_.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aop_.begin();
                        Object invoke = method.invoke(target_, args);
                        aop_.end();
                        return invoke;
                    }
                });
    }
}
