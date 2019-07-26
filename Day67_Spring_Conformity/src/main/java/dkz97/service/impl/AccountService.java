package dkz97.service.impl;

import dkz97.dao.IAccountDao;
import dkz97.domain.Account;
import dkz97.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountService implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    // 查询所有
    @Override
    public List<Account> findAll() {
        List<Account> all = accountDao.findAll();
        return all;
    }

    // 保存账户
    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }


    // 银行转账案例
    @Override
    public void transfer(String outAccount, String inAccount, Double money) {
        Account accountOut = accountDao.findByName(outAccount);
        Account accountIn = accountDao.findByName(inAccount);

        accountOut.setMoney(accountOut.getMoney() - money);
        accountIn.setMoney(accountIn.getMoney() + money);

        accountDao.updateAccount(accountOut);
        accountDao.updateAccount(accountIn);
    }


}
