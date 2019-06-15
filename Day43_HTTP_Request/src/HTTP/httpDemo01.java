package HTTP;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/demo01")
public class httpDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo01.....");

        // 获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        System.out.println("----------------");

        // 获取虚拟目录
        String context_path = req.getContextPath();
        System.out.println(context_path);
        System.out.println("----------------");

        // 获取虚拟路径
        String servlet_path = req.getServletPath();
        System.out.println(servlet_path);
        System.out.println("----------------");

        // 获取get方法的请求参数
        String request_paramater = req.getQueryString();
        System.out.println(request_paramater);
        System.out.println("----------------");

        // 获取uri和url
        String URI = req.getRequestURI();
        System.out.println(URI);
        StringBuffer url = req.getRequestURL();
        System.out.println(url);
        System.out.println("----------------");

        // 获取http协议
        String http_versions = req.getProtocol();
        System.out.println(http_versions);
        System.out.println("----------------");


        // 获取客户机的ip地址
        String client_ip = req.getRemoteAddr();
        System.out.println(client_ip);

        //获取所有请求头的名称
        Enumeration<String> request_headers = req.getHeaderNames();
        System.out.println(request_headers);
        // 遍历
        while (request_headers.hasMoreElements()) {
            String name = request_headers.nextElement();
            // 根据请求头名称获取值
            String value = req.getHeader(name);
            System.out.println(name + "-->" + value);
        }

        // 实现转发的功能
        RequestDispatcher disp = req.getRequestDispatcher("/demo04");
        disp.forward(req,resp);
        // 在域中设置数据
        req.setAttribute("usename","zhangsan");

        System.out.println("----------------");

        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost.....");
    }
}
