package dkz97.controller;

import dkz97.domain.User;
import dkz97.exception.SysExeception;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试的控制器类，主要用于测试响应返回值
 */
@Controller
@RequestMapping("/user")
public class UserController {


    /**
     * 测试返回值类型是String
     * @return
     */
    @RequestMapping("/testString")
    public String testString() {
        System.out.println("返回值为String测试运行...");
        return "success";
    }

    /**
     * 测试没有返回值
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("方法没有返回值测试运行....");

        // 进行request的转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 进行response的重定向
//        response.sendRedirect(request.getContextPath() + "/response.jsp");

        // 使用直接响应,由于直接响应需要设置中文乱码的响应体
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().print("直接响应测试成功");
    }

    /**
     * 测试返回值是ModelAndView类型
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        // 用ModelAndView的方法，存储数据到request中
        mv.addObject("username","张三");

        // 使用setViewName方法，找视图解析器进行视图解析给浏览器返回
        mv.setViewName("success");
        return mv;
    }

    /**
     * 测试springMvc的转发和重定向
     */
    @RequestMapping("/testForwardAndRedirect")
    public String testForwardAndRedirect(){
        System.out.println("测试SpringMvc的转发和重定向执行了...");

        //请求转发
//        return "forward:/WEB-INF/pages/success.jsp";

        // 重定向 ，记住不能走WEB-INF目录
        return "redirect:/response.jsp";
    }

    /**
     * 测试响应json数据
     */
    @RequestMapping("/testResponseJson")
    public @ResponseBody User testResponseJson(@RequestBody User user){
        System.out.println("获取的响应体为:" + user);
        return user;
    }

    /**
     * 模拟异常，使用spring的异常控制
     */
    @RequestMapping("/testError")
    public String testError() throws SysExeception {
        System.out.println("模拟异常类");

        // 模拟捕获异常
        try {
            int i = 10/0;
        }catch(Exception e) {
            e.printStackTrace();
            throw new SysExeception("系统出现了异常，除数问题");
        }

        return "success";
    }

    /**
     * 测试拦截器，看拦截器的情况
     */
    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("测试方法使用了...");
        return "success";
    }
}
