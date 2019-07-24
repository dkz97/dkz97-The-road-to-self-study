package dkz97.test.Account;

import dkz97.domain.Account;
import dkz97.service.impl.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 账户表的测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {

    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    /**
     * 测试转账案例
     */
    @Test
    public void testTransfer() {
        System.out.println("---------------转账前-------------");
        System.out.println(accountService.findAll());

        accountService.transfer("aaa","bbb",100);

        System.out.println("---------------转账后--------------");
        System.out.println(accountService.findAll());
    }
}
