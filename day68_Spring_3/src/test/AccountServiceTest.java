

import dkz97.domain.Account;
import dkz97.service.impl.AccountServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;

import java.util.List;

/**
 * Account 基于注解ioc的 案例测试
 * 两个注解是让junit可以使用spring注解配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("accountService")
    private AccountServiceImpl accountService;


    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    /**
     * 测试银行转行的案例
     */
    @Test
    public void testTransfer() {
        System.out.println(accountService.findAll());
        accountService.transfer("aaa","bbb",100);
        System.out.println("----------------------------------");
        System.out.println(accountService.findAll());
    }
}
