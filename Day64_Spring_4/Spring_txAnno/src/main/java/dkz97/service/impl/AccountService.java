package dkz97.service.impl;

import dkz97.dao.impl.AccountDao;
import dkz97.domain.Account;
import dkz97.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class AccountService implements IAccountService {



    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;


    /**
     * 寻找所有账户
     * @return
     */

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    /**
     * 银行转账的案例
     * @param outAccount 转出钱的账户名称
     * @param intoAccount 接受前的账户名称
     * @param money 转出转入的钱
     */
    @Transactional(readOnly =false,propagation = Propagation.REQUIRED)
    public void transfer(String outAccount, String intoAccount, int money) {

        //1. 根据转出账户和转入账户的名称找到对应账户的信息
        Account accountOut = accountDao.findByName(outAccount);
        Account accountInto = accountDao.findByName(intoAccount);

        //2. 转出账户扣钱，转入账户加钱
        accountOut.setMoney(accountOut.getMoney() - money);
        accountInto.setMoney(accountInto.getMoney() + money);

        //3. 两个账户都更新
        accountDao.updateAccount(accountOut);
        accountDao.updateAccount(accountInto);
    }
}
