package HTTP;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

// 用来实现，获取请求头信息来看是哪个浏览器的

@WebServlet("/demo03")
public class What_Browser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doget.....");
        String user_agent = req.getHeader("User-Agent");
        // 判断是哪个浏览器 使用字符串的方法 boolean contains(xx)  判断xx是否存在与字符串中
        if (user_agent.contains("Chrome")) {
            System.out.println("谷歌来了...");
        } else if (user_agent.contains("Safari")) {
            System.out.println("苹果来了....");
        } else {
            System.out.println("都不是");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost......");

    }
}
