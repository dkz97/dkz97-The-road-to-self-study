package dkz97.service.impl;

import dkz97.dao.AccountDao;
import dkz97.domain.Account;
import dkz97.service.AccountService;
import dkz97.utils.TransactionManager;

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

    public void deleteAccount(Integer id)
    {
        accountDao.deleteAccount(id);
    }


    /**
     * 银行转账的案例
     * @param outAccount 转出的账号
     * @param acceAccount 接收的账号
     * @param money 转出的钱
     */
    public void transfer(String outAccount, String acceAccount, int money) {

        /**
         * 事务操作(已经使用动态代理进行分离)
         * 1.开启事务
         * 2.进行操作
         * 3.事务提交
         * catch () 中 进行事务回滚
         * finally 中 进行释放资源
         */

        // 进行操作
        //1.根据名称查询转出账户
        Account accountOut = accountDao.findByName(outAccount);
        //2.根据名称查询接收账户的信息
        Account accountAcce = accountDao.findByName(acceAccount);
        //3.转出账户扣钱
        accountOut.setMoney(accountOut.getMoney() - money);
        //4.接收账户加钱
        accountAcce.setMoney(accountAcce.getMoney() + money);
        //5.更新转出账户
        accountDao.updateAccount(accountOut);
        //6.更新接收账户
        accountDao.updateAccount(accountAcce);


    }
}
