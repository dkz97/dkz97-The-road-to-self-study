package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UpdateServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post表单，先编码
        request.setCharacterEncoding("utf-8");

        // 获取表单的map，封装bean
        User user = new User();
        Map<String, String[]> par = request.getParameterMap();
        try {
            BeanUtils.populate(user,par);

            // 调用updateSerive
            new UpdateServiceImpl().updateService(user);

            // 跳转查询servlet
            RequestDispatcher dis = request.getRequestDispatcher("/pageServlet?currentPage=1&rows=5");
            dis.forward(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
