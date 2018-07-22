package cn.isdev.framework.test.proxy;


/**
 * Created by Administrator on 2018/7/22.
 */
public class ProxyTest {

    public static void main(String[] args){
        IUserDao userDao = new UserDao();
        ProxyFactory proxyFactory = new ProxyFactory(userDao);
        IUserDao proxy = (IUserDao) proxyFactory.getProxyInstance();
        proxy.save();
    }
}
