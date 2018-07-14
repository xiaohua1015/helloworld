package cn.isdev.xiaohua.servlet;

import cn.isdev.xiaohua.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/15.
 */
@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
//        ConvertUtils.register(new Converter() {
//            @Override
//            public <T> T convert(Class<T> type, Object value) {
//                if (type != Date.class) return null;
//                if(((String)value).isEmpty()){
//                    return null;
//                }
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                try {
//                    return (T) sdf.parse(value.toString());
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                    return null;
//                }
//            }
//        }, Date.class);
        ConvertUtils.register(new DateLocaleConverter(), Date.class);

//        try {
//            BeanUtils.populate(user, request.getParameterMap());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        try {
            BeanUtils.setProperty(user, "name", "xiaohua");
            BeanUtils.copyProperty(user, "password", "123456");
            BeanUtils.copyProperty(user, "birth", "1990-08-09");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(user);
    }



}
