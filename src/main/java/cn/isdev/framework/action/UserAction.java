package cn.isdev.framework.action;

import cn.isdev.framework.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/21.
 */
@Controller
public class UserAction extends ActionSupport {

    @Resource(name = "userService")
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String save() {
        userService.save();
        return SUCCESS;
    }

    public String delete() {
        return "delete";
    }
}
