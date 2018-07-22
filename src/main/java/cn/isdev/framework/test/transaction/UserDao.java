package cn.isdev.framework.test.transaction;

import cn.isdev.framework.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/23.
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user){
        String sql = "insert into user (name, password) values(?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getPassword());
    }
}
