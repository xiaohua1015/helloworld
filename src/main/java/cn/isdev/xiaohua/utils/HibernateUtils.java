package cn.isdev.xiaohua.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Administrator on 2018/7/19.
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        // 在5.1.0版本汇总，hibernate则采用如下新方式获取：
        // 1. 配置类型安全的准服务注册类，这是当前应用的单例对象，不作修改，所以声明为final
        // 在configure("cfg/hibernate.cfg.xml")方法中，如果不指定资源路径，默认在类路径下寻找名为hibernate.cfg.xml的文件
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        // 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
    }

    public static Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }
}
