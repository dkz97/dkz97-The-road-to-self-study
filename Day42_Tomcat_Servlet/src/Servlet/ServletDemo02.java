package Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

// 通过添加注解来进行标签增加
// 在括号内对其进行配置属性，这个注解的源代码为
/*
* public @interface WebServlet {
    String name() default "";//相当于<Servlet-name>

    String[] value() default {};//代表urlPatterns()属性配置

    String[] urlPatterns() default {};//相当于<url-pattern>

	int loadOnStartup() default -1;//相当于<load-on-startup>

	WebInitParam[] initParams() default {};

	boolean asyncSupported() default false;

	String smallIcon() default "";

	String largeIcon() default "";

	String description() default "";

	String displayName() default "";
				}
*/
// 并且是可以多个路径都行的
//@WebServlet("/demo02")
/*
* urlpartten:Servlet访问路径
			1. 一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
			2. 路径定义规则：
				1. /xxx：路径匹配
				2. /xxx/xxx:多层路径，目录结构
				3. *.do：扩展名匹配
*/
@WebServlet(urlPatterns = {"/demo02","/dede","/demo.do"})
public class ServletDemo02 implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
