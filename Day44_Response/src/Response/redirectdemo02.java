package Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 重定向案例
@WebServlet("/demo02")
public class redirectdemo02 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先设置响应行的信息 302
        resp.setStatus(302);

//        // 设置响应头的的location
        resp.setHeader("location","/day44/demo01");

        // 简单把地址告诉浏览器让其去别的地方重定向
        resp.sendRedirect("/day44/demo01");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
    }
}
