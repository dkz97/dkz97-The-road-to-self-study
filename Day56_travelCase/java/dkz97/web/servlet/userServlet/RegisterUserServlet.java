package dkz97.web.servlet.userServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dkz97.domain.ResultInfo;
import dkz97.domain.User;
import dkz97.service.impl.UserServiceImpl;
import dkz97.utils.UuidUtil;
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

@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // filter已经设置了请求编译，所以主要设置响应编码
        response.setContentType("application/json;charset=utf-8");
        // 接收数据，在数据中拿出用
        Map<String, String[]> map = request.getParameterMap();

        // 先验证验证码的，验证码通过就通过，失败就直接返回不通过
        String login_check = map.get("check")[0];
        // 从验证码的servlet中获取验证码
        HttpSession session = request.getSession();
        String checkcode = (String) session.getAttribute("CHECKCODE_SERVER");
        // 一拿到验证码就杀死验证码
        session.removeAttribute("CHECKCODE_SERVER");

        // 创建User对象还有信息对象
        User user = new User();
        ResultInfo info = new ResultInfo();

        // 验证码正确，验证码不区分大小写进行比较
        if (checkcode != null && checkcode.equalsIgnoreCase(login_check)) {

            // 对数据进行封装
            try {
                // 对获取到的数据封装到对象中
                BeanUtils.populate(user, map);

                // 调用service中的注册方法
                boolean flag = new UserServiceImpl().register(user);

                // 判断进行操作,使用resultInfo对象封装数据，然后变成json，响应回html
                if (flag) {
                    // 就是注册成功
                    info.setFlag(true);
                } else {
                    //注册失败，返回失败的信息

                    info.setFlag(false);
                    info.setErrorMsg("用户名存在，注册失败！");
                }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }  else {
            //验证码错误
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
        }


        // 封装json对象，然后响应回前端
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(info);
        response.getWriter().write(string);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
