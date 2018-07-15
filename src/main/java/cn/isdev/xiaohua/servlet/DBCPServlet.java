package cn.isdev.xiaohua.servlet;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2018/7/16.
 */
@WebServlet(name = "DBCPServlet")
public class DBCPServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        dbcpTest();
        ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql_config");
        try {
            Connection connection = dataSource.getConnection();
            for(int i=0; i<30; i++){
                connection.prepareStatement("insert into user (name, password) values ('小明" + i + "', 'qwer123456')").executeUpdate();
            }
            connection.close();
            response.getWriter().write("sql 执行成功");
        } catch (SQLException e) {
            response.getWriter().write("sql 执行失败");
            e.printStackTrace();
        }
    }

    private void dbcpTest() throws IOException {
        //        BasicDataSource  dataSource = new BasicDataSource();
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/dbcp.properties"));
        try {
            BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(prop);
            Connection connection = dataSource.getConnection();
            connection.prepareStatement("delete from user where id = 5").executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
