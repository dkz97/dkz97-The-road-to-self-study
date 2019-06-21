package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UserListServiceimpl;
import service.impl.UserLoginServiceimpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("utf-8");

        // 获取数据,表单提交之后可以用request来获取表头和值
        String login_vcode = request.getParameter("verifycode");

        // 先验证验证码，并且获取验证码后就把验证码取消，确保验证码的一次性
        HttpSession session = request.getSession();
        Object vcode = session.getAttribute("vcode");
        session.removeAttribute("vcode");

        if (login_vcode != null && vcode != null && login_vcode.equals(vcode)) {

            // 封装对象,获得所有数据键值对来封装
            Map<String, String[]> parMap = request.getParameterMap();

            User login_user = new User();
            try {
                BeanUtils.populate(login_user, parMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            // 调用service查询
            User user = new UserLoginServiceimpl().login(login_user);
            if (user != null) {
                RequestDispatcher dispat = request.getRequestDispatcher("index.jsp");
                dispat.forward(request,response);
            } else {
                request.setAttribute("login_error","账号或密码错误");
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                dis.forward(request,response);
            }

        } else {
            request.setAttribute("login_error","验证码错误");
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request,response);
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
