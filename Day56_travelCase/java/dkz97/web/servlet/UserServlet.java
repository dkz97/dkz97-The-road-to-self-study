package dkz97.web.servlet;


// 创建一个user的servlet，创建多个方法，继承baseServlet，主要调用的还是baseServlet中的service方法
// 然后再service方法，使用userServlet的各种方法

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dkz97.domain.ResultInfo;
import dkz97.domain.User;
import dkz97.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{



    // 登陆的方法
    public void login (HttpServletRequest request, HttpServletResponse response) throws IOException {

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


    // 注册的方法
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException {

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

    // 检验激活码的方法
    public void checkCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 首先获取code
        String code = request.getParameter("code");

        // 调用service的验证激活码的方法
        UserServiceImpl userService = new UserServiceImpl();
        boolean flag = userService.checkCode(code);

        if (flag) {
            // 返回true的话就是证明存在，并且已经修改完毕
            response.getWriter().write("您好，激活成功，点击<a href='http://localhost:8080/login.html'>登陆</a>");
        } else {
            // 返回false的话就是激活码不存在,让其联系管理员
            response.getWriter().write("激活码不存在，请联系管理员");
        }

    }


    /**
     * 用来与head.html交互，生成头信息的方法
     *
     */

    public void findUser(HttpServletRequest request,HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        // 因为在登陆的时候把user对象存储在,session中，可以直接获取

        Object user = session.getAttribute("user");
        //封装成json对象返回给客户端，设置编码
        response.setContentType("application/json;charset=utf8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),user);
    }


    /**
     * 退出登陆的方法
     */

    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 从session中拿到user账号，然后删除账号后返回就行
        HttpSession session = request.getSession();

        session.invalidate();

        // 先拿到连接路径然后加上重定向路径才行
        response.sendRedirect(request.getContextPath() + "/index.html");
    }



}
