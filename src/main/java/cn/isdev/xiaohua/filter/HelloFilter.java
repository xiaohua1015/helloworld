package cn.isdev.xiaohua.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/16.
 */
public class HelloFilter implements Filter {

    private String[] pages;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         System.out.println("hello filter init");
        String excludePages = filterConfig.getInitParameter("excludePages");
        pages = excludePages.split(",");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hello filter doFilter 执行servlet前");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        boolean flag = true;
        System.out.println(request.getServletPath());
        for (String page:pages) {
            System.out.println("page = " + page);
            if(request.getServletPath().equals(page)){
                flag = true;
            }
        }
        if (flag) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath()+"index.jsp");
        }
        System.out.println("hello filer doFilger 执行servlet之后");
    }

    @Override
    public void destroy() {
        System.out.println("hello filer destroy");
    }
}
