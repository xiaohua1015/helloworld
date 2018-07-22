package cn.isdev.framework.test.proxy;

/**
 * Created by Administrator on 2018/7/22.
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("DB:保存数据");
    }
}
