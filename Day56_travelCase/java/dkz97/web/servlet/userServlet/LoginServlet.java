package dkz97.web.servlet.userServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dkz97.domain.ResultInfo;
import dkz97.domain.User;
import dkz97.service.impl.UserServiceImpl;
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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置响应的编码
        response.setContentType("application/json;charset=utf-8");


        // 接收登陆数据
        Map<String, String[]> map = request.getParameterMap();

        // 创建错误信息对象
        ResultInfo info = new ResultInfo();

        // 验证验证码是否正确
            //  1.获取登陆的验证码
        String login_check = map.get("check")[0];
            //  2.获取当前的验证码，并且获取后立刻销毁，防止复用
        HttpSession session = request.getSession();
        String check = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");

        if ((check != null) && check.equalsIgnoreCase(login_check)) {
            // 封装对象
            User login_user = new User();
            try {
                BeanUtils.populate(login_user, map);

                //调用service的login方法
                UserServiceImpl userService = new UserServiceImpl();
                User user = userService.login(login_user);

                // 判断user是否存在
                if (user != null) {
                    // 如果不为空，则证明查询到，是存在的
                        // 然后再判断激活状态，看是否激活
                    if (user.getStatus().equals("Y")) {
                        // 已经激活
                        info.setFlag(true);
                        session.setAttribute("user",user);


                    }else {
                        info.setFlag(false);
                        info.setErrorMsg("请先激活账号");
                        // 没有激活
                    }
                } else {
                    // 账号或者密码错误，获得的对象为空
                    info.setFlag(false);
                    info.setErrorMsg("账号或者密码错误");
                }



            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            // 验证码错误
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
        }

        // 与前端进行交互
            //1.封装info为json对象
        ObjectMapper mapper = new ObjectMapper();
            //2.响应给前端
        mapper.writeValue(response.getOutputStream(),info);

    }
}
