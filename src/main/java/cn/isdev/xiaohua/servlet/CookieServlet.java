package cn.isdev.xiaohua.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/9.
 */
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        cookieTest(request, response);
        HttpSession session = request.getSession();
        session.setAttribute("name", "xiaohua");
    }

    private void cookieTest(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("age", "24");
        cookie.setPath("/webtest");
        cookie.setMaxAge(0);
        // 响应头携带cookie返回给浏览器，并保存在浏览器当中
        response.addCookie(cookie);
        // 当浏览器中保存了cookie之后（cookie浏览器的默认有效路径为当前web目录下），浏览器下次访问服务器，请求头会携带cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie coo: cookies) {
                System.out.println("name = " + coo.getName());
                System.out.println("value = " + coo.getValue());
            }
        } else {
            System.out.println("没有cookie");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
