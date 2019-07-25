package dkz97.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring Mvc 的控制器类
 * 使用Spring ioc注解，controller,把对象加入到ioc容器中
 */
@Controller
public class HelloController {

    // requestMapping 这个注解可以让这个方法给个路径
    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("hello执行了");
        return "success";
    }



}
