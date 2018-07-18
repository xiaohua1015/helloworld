package cn.isdev.xiaohua.servlet;

import cn.isdev.struts.bean.UserEntity;
import cn.isdev.xiaohua.bean.User;
import cn.isdev.xiaohua.jdbc.UserDao;
import cn.isdev.xiaohua.utils.JdbcUtilsBase;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/15.
 */
@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset= utf-8");
//        beanUtils();
//        useDao();
//        DbUtilsBase(response);
//        DbUtilsQueryOne(response);
//        DbUtilsQueryMany(response);
//        dbUtilsScalar(response);
        test(request, response);
    }

    private void test(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.sendRedirect(request.getContextPath()+"/cookie");
//        request.getRequestDispatcher(request.getContextPath()+"cookie").forward(request, response);
//        String user = request.getParameter("user");
//        System.out.println("user = " + user);
//        response.getWriter().write("user = " + user);
//        log4jTest();
        hibernateTest();
    }

    private void hibernateTest() {
        UserEntity userEntity = new UserEntity(12, "小雷", "12345678");
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            session.saveOrUpdate(userEntity);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            session.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
////            Session currentSession = sessionFactory.getCurrentSession();
////            UserEntity user = session.get(UserEntity.class, 12);
////            System.out.println("get user = " + user);
//            session.close();
//        }
//        Query query = session.createQuery("from UserEntity where id=?1");
//        query.setParameter(1, 12);
//        List list = query.list();
//        System.out.println("list = " + list);

        // SQL 语句查询
//        NativeQuery sqlQuery = session.createSQLQuery("select * from user where id = 12").addEntity(UserEntity.class);
//        System.out.println("list = " + sqlQuery.list());
        // 分页查询
        Query query = session.createQuery("from UserEntity");
        query.setFirstResult(2);
        query.setMaxResults(4);
        List list = query.list();
        System.out.println("list = " + list);

        // 删除
        try {
            session.beginTransaction();
            UserEntity user = session.get(UserEntity.class, 42);
            if (user != null) {
                session.delete(user);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        session.close();
    }

    private void log4jTest() {
        Log log = LogFactory.getLog(TestServlet.class);
        try {
            log.info("开始计算");
            int tmp = 1/0;
            log.info("计算结束");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("计算异常" , e);
        }
    }

    private void dbUtilsScalar(HttpServletResponse response) throws IOException {
        String sql = "select * from user";
        Connection conn = JdbcUtilsBase.getConn();
        QueryRunner queryRunner = new QueryRunner();
        Integer id = 0;
        try {
            id = queryRunner.query(conn, sql, new ScalarHandler<Integer>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().write(String.valueOf(id));
    }

    private void DbUtilsQueryMany(HttpServletResponse response) throws IOException {
        String sql = "select * from user";
        Connection conn = JdbcUtilsBase.getConn();
        QueryRunner queryRunner = new QueryRunner();
        List<User> users = null;
        try {
            users = queryRunner.query(conn, sql, new BeanListHandler<User>(User.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        writer.write(users.toString());
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void DbUtilsQueryOne(HttpServletResponse response) throws IOException {
        String sql = "select * from user where id = ?";
        Connection conn = JdbcUtilsBase.getConn();
        QueryRunner queryRunner = new QueryRunner();
        User user = null;
        try {
            user = queryRunner.query(conn, sql, new BeanHandler<User>(User.class), 6);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        writer.write(user.toString());
    }

    private void DbUtilsBase(HttpServletResponse response) throws IOException {
        String sql = "select * from user";
        Connection conn = JdbcUtilsBase.getConn();
        QueryRunner qr = new QueryRunner();
        try {
            List<User> userList = qr.query(conn, sql, new ResultSetHandler<List<User>>() {
                @Override
                public List<User> handle(ResultSet resultSet) throws SQLException {
                    List<User> list = new ArrayList<>();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int metaDataCount = metaData.getColumnCount();
                    while(resultSet.next()) {
                        User user = new User();
                        for(int i=0; i<metaDataCount; i++){
                            String columnName = metaData.getColumnName(i + 1);
                            Object object = resultSet.getObject(columnName);
                            try {
                                BeanUtils.copyProperty(user, columnName, object);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        list.add(user);
                    }
                    return list;
                }
            });

            PrintWriter writer = response.getWriter();
            writer.write("userList = " + userList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void useDao() {
        UserDao userDao = new UserDao();
//        userDao.delete(4);
//        userDao.save(new User(1,"小华", "wahaha123456", new Date()));
        List<User> userList = userDao.getAll();
        System.out.println(userList);
    }

    private void beanUtils() {
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
