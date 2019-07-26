package dkz97.controller;

import dkz97.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主要是用于与web接口进行操作的controller
 */
@Controller
@RequestMapping("/account")
public class AccountController {


    @Autowired
    private AccountService accountService;

    /**
     *测试springmvc配置和spring框架的融合
     */
    @RequestMapping("/demo01")
    public String testDemo01(){
        System.out.println("springMvc配置成功...");
        System.out.println(accountService.findAll());
        return "success";
    }

    /**
     * 测试ssm框架的整合
     */
    @RequestMapping("/ssm")
    public String testSSM() {
        System.out.println(accountService.findAll());
        return "success";
    }

    /**
     * 测试银行转行案例
     */
    @RequestMapping("/transfer")
    public String testTransfer(String name1,String name2,Double money){
        System.out.println(name1 +"-" + name2 + "-"+ money);
        accountService.transfer(name1,name2,money);
        return "success";
    }

}
