package web.servlet;

import dao.impl.UserDoimpl;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取删除的数据
        String count = req.getParameter("id");
        int i = Integer.parseInt(count);


        // 调用删除的方法
        UserDoimpl userDoimpl = new UserDoimpl();
        userDoimpl.deleteUser(i);

        // 返回listservlet再次查询
        resp.sendRedirect(req.getContextPath() + "/pageServlet?currentPage=1&rows=5");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
