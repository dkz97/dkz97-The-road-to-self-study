package dkz97.service.impl;

import dkz97.dao.AccountDao;
import dkz97.domain.Account;
import dkz97.service.AccountService;

import java.util.List;


/**
 * Account业务层接口的实现类
 */
public class AccountServiceImpl implements AccountService {

    /**
     * 调用的是dao的接口，需要dao对象
     * @return
     */
    private  AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }



    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
