package dkz97.Account.test;


import dkz97.service.IAccountService;
import dkz97.service.impl.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

        // 获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据id获取对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        // 调用方法
        accountService.saveAccount();
    }
}
