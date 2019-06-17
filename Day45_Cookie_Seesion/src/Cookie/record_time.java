package Cookie;


// 小案例，记住上次登陆时间
// 由于cookie特殊字符不能存储，所以可以适当的对传入的str进行Url编码和解码


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/demo01")
public class record_time extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应的字符集
        resp.setContentType("text/html;charset=utf-8");

        // 获取cookies
        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        // 判断是否为空
        if (cookies != null){
            for (Cookie cookie: cookies) {
                // 获取名称
                // 获取当前系统时间
                String str = (new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")).format(new Date());
                // 先url编码再进行存储
                String encode = URLEncoder.encode(str, "utf-8");
                Cookie cookie_time;
                if (cookie.getName().equals("lastTime")) {
                    // 设置cookie对象
                    cookie_time = new Cookie("lastTime", encode);
                    // 发送cookie对象
                    resp.addCookie(cookie_time);

                    // 不是第一次登陆,由于时间是url编码的，所以先url解码
                    String time = cookie.getValue();
                    String decode = URLDecoder.decode(time, "utf-8");
                    resp.getWriter().write("<h1>欢迎回来，你上次登陆时间为</h1>" + decode);

                    flag = true;
                    break;
                }
            }
        }
        // 如果没有cookie或者没有lasttime的时候
        if (cookies == null || cookies.length == 0 || flag == false) {
            String str = (new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")).format(new Date());
            // 可以先转化为url编码再传入
            String encode = URLEncoder.encode(str, "utf-8");
            Cookie cookie_time;
            // 第一次登陆
            resp.getWriter().write("<h1>你好，这是您第一次登陆</h1>");
            // 设置cookie对象
            cookie_time = new Cookie("lastTime", encode);
            // 发送cookie对象
            resp.addCookie(cookie_time);
        }


    }
}
