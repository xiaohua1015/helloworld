package cn.isdev.framework.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * Created by Administrator on 2018/7/22.
 */
public class ProxyFactory1 {

    private Object target;

    public ProxyFactory1(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理开始");
                        Object invoke = method.invoke(target, args);
                        System.out.println("动态代理结束");
                        return invoke;
                    }
                });
    }
}
