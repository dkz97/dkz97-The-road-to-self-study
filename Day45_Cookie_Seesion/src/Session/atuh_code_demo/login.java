package Session.atuh_code_demo;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

/*
* 1. 访问带有验证码的登录页面login.jsp
2. 用户输入用户名，密码以及验证码。
* 如果用户名和密码输入有误，跳转登录页面，提示:用户名或密码错误
* 如果验证码输入有误，跳转登录页面，提示：验证码错误
* 如果全部输入正确，则跳转到主页success.jsp，显示：用户名,欢迎您*/

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login....执行");
        // 设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");

        // 通过session获取验证码
        HttpSession session = request.getSession();
        String authCode = (String) session.getAttribute("authCode");

        // 遍历请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 将map，使用Beanutils工具类封装成User对象,然后对象中就已经存储了
        User login_user = new User();
        try {
            BeanUtils.populate(login_user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(login_user);


        // 获取输入的验证码
        String login_authCode = request.getParameter("authCode");
        //先判断验证码是否正确
        if (login_authCode != null) {
            if (login_authCode.equals(authCode)) {
                //验证码正确，之后就可以判断账号密码
                User user = UserDo.login(login_user);
                if (user != null) {
                    response.getWriter().write("登陆成功，欢迎您");
                } else {
                    //账号或密码错误
                    response.getWriter().write("账号或错误");
                    response.getWriter().write("<a href='/day45/login.jsp'>返回</a>");
                }

            }else {
                //验证码错误
                response.getWriter().write("验证码错误");
                response.getWriter().write("<a href='/day45/login.jsp'>返回</a>");
            }
            }
        }


    }

