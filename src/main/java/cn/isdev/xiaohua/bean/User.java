package cn.isdev.xiaohua.bean;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/15.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private Date birth;

    public User() {
    }

    public User(int id, String name, String password, Date birth) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birth=" + birth +
                '}';
    }
}
