package web.servlet;

import domain.Page;
import domain.User;
import service.impl.FindUserBypageimpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 接收请求的参数currentPage(当前页码),和rows(每页显示的数据)
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        // // 获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();
        Set<String> strings = condition.keySet();
        for (String string : strings) {
            System.out.println(string +"-->" + condition.get(string)[0]);
        }

        // 调用service来查询pageBean
        Page<User> userPage = FindUserBypageimpl.findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows),condition);

        request.setAttribute("page",userPage);
        request.setAttribute("condition",condition);
        RequestDispatcher dis = request.getRequestDispatcher("/list.jsp");
        dis.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
