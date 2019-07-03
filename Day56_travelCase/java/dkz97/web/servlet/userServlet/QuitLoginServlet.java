package dkz97.web.servlet.userServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 用来退出登陆的servlet
@WebServlet("/quitLoginServlet")
public class QuitLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            // 从session中拿到user账号，然后删除账号后返回就行
        HttpSession session = request.getSession();

        session.invalidate();

        // 先拿到连接路径然后加上重定向路径才行
        response.sendRedirect(request.getContextPath() + "/index.html");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
