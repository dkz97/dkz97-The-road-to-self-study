package dkz97.controller;

import dkz97.exception.SysExeception;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这个是一个异常控制器，需要继承HandlerExceptionResolver ，并且重写方法
 */
public class ErrorController implements HandlerExceptionResolver {

    /**
     * 这个主要就是捕获到异常之后，应该怎么做
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param ex ex这个参数就是接收到的异常对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        // 首先判断接收到的异常对象是否为自定义异常对象
        SysExeception e =null;
        if (ex instanceof SysExeception) {
            // 如果是这个类型，就直接转换就行
            e = (SysExeception) ex;
        } else {
            // 如果不是，就创建一个
            e = new SysExeception("系统正在维护....");
        }

        //返回值是ModelAndView对象，可以创建一个新对象，然后帮忙跳转
        ModelAndView mv = new ModelAndView();
        //主要是把错误提示信息存储到request中，然后进行页面跳转
        mv.addObject("error",e.getMessage());
        mv.setViewName("error");

        // 还要把mv 给return 出去才行
        return mv;
    }
}
