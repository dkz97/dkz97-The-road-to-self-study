package HTTP;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 用来实现防盗链的
@WebServlet("/demo02")
public class anti_stealing_link extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) {
        System.out.println("demo02..");
        // 获得referer对象的值
        String referer = req.getHeader("Referer");
        if (referer.contains("/day43/Httptextdemo.html")) {
            System.out.println("就是这里了..");
        } else {
            System.out.println("走错了");
        }
    }
}
