package Servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo01 implements Servlet {

    // init 一访问就会启动的方法，并且只会启动一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service 每次访问都会启动一次的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service......");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    // 当Tomcat结束的时候使用的方法
    @Override
    public void destroy() {

    }
}
