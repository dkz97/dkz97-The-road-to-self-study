package web.servlet;

import dao.impl.UserDoimpl;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.AddUserServiceimpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;


@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 因为是post表单的所以设置编码
        req.setCharacterEncoding("utf-8");

        // 获取添加的数据
        User user = new User();
        Map<String, String[]> parMap = req.getParameterMap();
        // 封装User对象
        try {
            BeanUtils.populate(user,parMap);
            // 调用AddUserService来添加对象并且保存
            UserDoimpl userdoimpl = new UserDoimpl();
            userdoimpl.addUser(user);
            // 跳转到UserListServlet再次查询数据
            resp.sendRedirect(req.getContextPath() + "/pageServlet?currentPage=1&rows=5");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
