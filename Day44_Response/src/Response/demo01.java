package Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo01")
public class demo01 extends HttpServlet {

    protected void doPost(HttpServletRequest hreq, HttpServletResponse hresp) {
        System.out.println("dopost..");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget...");
        // 设置响应行的码
        resp.setStatus(201);
        //设置响应头
        resp.setHeader("name","zhangsan");
        // 设置响应体
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>hello World!</h1>");

    }
}
