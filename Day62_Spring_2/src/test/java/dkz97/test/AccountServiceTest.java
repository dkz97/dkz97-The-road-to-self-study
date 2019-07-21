package dkz97.test;

import dkz97.domain.Account;
import dkz97.service.impl.AccountServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Account 基于注解ioc的 案例测试
 */
public class AccountServiceTest {

    private static AccountServiceImpl accountService;

    @Before
    public void init() {

        // 1.获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据id，获取可以service对象
        accountService = ac.getBean("accountService", AccountServiceImpl.class);

    }


    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    @Test
    public void testFindById() {
        Account account = accountService.findById(2);
        System.out.println(account);
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setMoney(3000);
        account.setName("杨和苏");

        accountService.saveAccount(account);
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setName("大傻");
        account.setMoney(2000);
        account.setId(4);

        accountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount() {
        accountService.deleteAccount(4);
    }
}
