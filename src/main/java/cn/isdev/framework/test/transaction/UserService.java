package cn.isdev.framework.test.transaction;

import cn.isdev.framework.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2018/7/23.
 */
public class UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
//        int tmp =1/0;
        userDao.save(user);
    }
}
