package web.servlet;

import dao.impl.UserDoimpl;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先设置编码
        request.setCharacterEncoding("utf-8");

        // 获取当前修改页面的id
        String id = request.getParameter("id");
        UserDoimpl userdo = new UserDoimpl();
        User user = userdo.findId(Integer.parseInt(id));

        // 查询到相对应的user之后就转发到update.jsp
        RequestDispatcher dis = request.getRequestDispatcher("/update.jsp");
        request.setAttribute("user",user);
        dis.forward(request,response);






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
