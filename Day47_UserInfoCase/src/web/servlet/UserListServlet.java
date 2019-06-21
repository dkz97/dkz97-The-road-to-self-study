package web.servlet;


// 这个是查询列表的实现类，可以查询所有的成员信息，并且封装到request中

import domain.User;
import service.impl.UserListServiceimpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listServlet")
public class UserListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
        try {
            List<User> users = new UserListServiceimpl().findAll();
            // 使用转发，先获取转发器对象
            req.setAttribute("Users",users);
            RequestDispatcher dis = req.getRequestDispatcher("/list.jsp");
            dis.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}