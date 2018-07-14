package cn.isdev.xiaohua.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2018/7/8.
 */
public class CycleLifeServlet extends HttpServlet {
    public CycleLifeServlet() {
        super();
        System.out.println("CycleLifeServlet constructor");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("CycleLifeServlet init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("CycleLifeServlet service");
    }

    int count = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        mutilThread(response);
//        servletConfig(response);
        ServletContext servletContext = this.getServletContext();
        String contextPath = servletContext.getContextPath();
        // 相对于tomcat webapp下的目录来说的，比如在webapp下目录为webtest,则contextPath=/webtest
        System.out.println("contextPath = " + contextPath);
        String param = servletContext.getInitParameter("contextParam");
        System.out.println("param = " + param);
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void servletConfig(HttpServletResponse response) throws IOException {
        String path = this.getServletConfig().getInitParameter("path");
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String str = null;
        while ((str = reader.readLine()) != null) {
            response.getWriter().println(str);
        }

        Enumeration<String> initParameterNames = this.getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            System.out.println(name + ":" + this.getServletConfig().getInitParameter(name));
        }
        System.out.println("servletName = " + this.getServletConfig().getServletName());
    }

    private void mutilThread(HttpServletResponse response) throws IOException {
        synchronized (CycleLifeServlet.class) {
            response.getWriter().write("你是这个网站的" + count + "访客");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("CycleLifeServlet destroy");
    }
}
