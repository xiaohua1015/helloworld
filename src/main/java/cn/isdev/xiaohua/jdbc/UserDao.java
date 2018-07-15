package cn.isdev.xiaohua.jdbc;

import cn.isdev.xiaohua.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2018/7/15.
 */
public class UserDao extends BaseDao {

    public void delete(int id){
        String sql = "delete from user where id = ?";
        Object[] paramsValues = {id};
        super.update(sql, paramsValues);
    }

    public void save(User user) {
        String sql = "insert into user (username, password) values(?,?)";
        Object[] paramsValues = {user.getName(), user.getPassword()};
        super.update(sql, paramsValues);
    }


    public List<User> getAll(){
        String sql = "select * from user";
        List<User> list = super.query(sql, null, User.class);
        return  list;
    }
}
