package cn.isdev.framework.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/7/21.
 */
@Repository
public class UserDao {

    public void save() {
        System.out.println("DB：保存数据");
    }
}
