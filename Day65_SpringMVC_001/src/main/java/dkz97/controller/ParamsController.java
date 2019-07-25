package dkz97.controller;

import dkz97.domain.Account;
import dkz97.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试绑定参数的控制类
 */
@Controller
@RequestMapping(path = "/params")
@SessionAttributes(value = {"aaa"})
public class ParamsController {

    /**
     * 测试传入的参数为基本类型的
     */
    @RequestMapping("/int")
    public String testint(int number) {
        System.out.println("基本类型传入参数测试" + number);
        return "success";
    }

    /**
     * 测试传入bean类型，直接封装
     */
    @RequestMapping("/account")
    public String testAccount(Account account) {
        System.out.println(account);
        return "success";
    }

    /**
     * 给内部类传入数值
     */
    @RequestMapping("/account2")
    public String testAccount2(Account account) {
        System.out.println(account);
        return "success";
    }

    /**
     * RequestParam注解的练习
     */
    @RequestMapping("requestParam")
    public String testRequestParam(@RequestParam(value = "uname") String name) {
        System.out.println(name);
        return "success";
    }

    /**
     * ModelAttribute注解有返回值的的练习
     */
//    @RequestMapping("modelAttribute")
//    public String testModelAttribute(User user){
//        System.out.println(user);
//        return "success";
//    }
//
//    @ModelAttribute
//    public User test(String uname) {
//        User user = new User();
//        user.setUname(uname);
//        user.setAge("20");
//        return user;
//    }

    /**
     * ModelAttribute 注解 没有返回值的练习
     */
    @RequestMapping("modelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user){
        System.out.println(user);
        return "success";
    }
    @ModelAttribute
    public void test(String uname, HashMap<String,User> map) {
        // 模拟根据名称中数据库中读取数据，然后存储到map中，再传递给上面的那个方法
        User user = new User();
        user.setUname(uname);
        user.setAge("30");

        map.put("user",user);
    }

    /**
     * 测试sessionAttribute注解
     */
    // 加入参数
    @RequestMapping("modeladd")
    public String testmodeladd(Model model) {
        // 会存储到request 域中
        model.addAttribute("aaa","bbb");
        return "success";
    }
    // 获取参数
    @RequestMapping("getattr")
    public String testgetattr(ModelMap modelMap) {
        System.out.println(modelMap.get("aaa"));
        return "success";
    }
    // 清空参数
    @RequestMapping("clear")
    public String testclear(SessionStatus sessionAttribute) {
        sessionAttribute.setComplete();
        System.out.println("清空");
        return "success";
    }

}
