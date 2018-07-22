package cn.isdev.framework.test.aop;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/22.
 */
@Component
public class UserDao implements IUserDao {

    /*@Resource(name = "aop")
    private Aop aop;*/
    @Override
    public void save() {
//        aop.begin();
        System.out.println("核心业务逻辑");
//        aop.end();
    }

}
