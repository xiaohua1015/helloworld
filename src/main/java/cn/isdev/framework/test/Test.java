package cn.isdev.framework.test;

import cn.isdev.framework.bean.Dept;
import cn.isdev.xiaohua.utils.HibernateUtils;
import org.hibernate.Session;

/**
 * Created by Administrator on 2018/7/19.
 */
public class Test {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSession();
        Dept dept = session.get(Dept.class, 1);
        System.out.println("dept.employee = " + dept.getEmps());
        session.close();
    }
}
