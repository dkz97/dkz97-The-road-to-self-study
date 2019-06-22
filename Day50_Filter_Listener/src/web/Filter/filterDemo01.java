package web.Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter("/*")
public class filterDemo01 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("拦截之前的代码....");

        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("拦截之后的代码....");

    }


    @Override
    public void destroy() {

    }
}
