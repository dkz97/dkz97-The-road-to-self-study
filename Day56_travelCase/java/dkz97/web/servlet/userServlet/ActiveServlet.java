package dkz97.web.servlet.userServlet;

import dkz97.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 用来接收验证邮箱的servlet
@WebServlet("/activeServlet")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 首先获取code
        String code = request.getParameter("code");

        // 调用service的验证激活码的方法
        UserServiceImpl userService = new UserServiceImpl();
        boolean flag = userService.checkCode(code);

        if (flag) {
            // 返回true的话就是证明存在，并且已经修改完毕
            response.getWriter().write("您好，激活成功，点击<a href='login.html'>登陆</a>");
        } else {
            // 返回false的话就是激活码不存在,让其联系管理员
            response.getWriter().write("激活码不存在，请联系管理员");
        }



    }
}
