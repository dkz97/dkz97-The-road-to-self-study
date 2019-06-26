package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 用来接收用户名的servlet
@WebServlet("/verifyServlet")
public class verifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置用户编码
        request.setCharacterEncoding("utf-8");
        // 设置响应的MIME和编码
        response.setContentType("text/html;charset=utf-8");
        // 可以设置响应的MIME为json的类型，然后客户端的回调函数就直接识别
        // response.setContentType("application/json;charset=utf-8")

        // 获取AJAX传过来的值，然后再进行校验
        String username = request.getParameter("username");
        Map<String,Object> map = new HashMap<String,Object>();
        // 根据传过来的username，来创建map集合
        if (username.equals("zhangsan")) {
            map.put("userExist",true);
            map.put("msg","用户名已经存在，请更换");
        } else {
            map.put("userExist",false);
            map.put("msg","用户名可以使用");
        }

        // 然后把map集合转换成json，然后使用方法，然后传递给客户端浏览器
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(response.getWriter(),map);
    }
}
