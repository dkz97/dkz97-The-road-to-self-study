package web.servlet;

import service.impl.DeleteSelectServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectServlet")
public class deleteSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post表单设置编码
        request.setCharacterEncoding("utf-8");
        // 获取所有的id值
        String[] uids = request.getParameterValues("uid");

        // 调用service方法通过id删除
        new DeleteSelectServiceimpl().delSelectService(uids);

        // 重定向到listServlet中
        response.sendRedirect(request.getContextPath() + "/pageServlet?currentPage=1&rows=5");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
