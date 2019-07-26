package dkz97.service;

import dkz97.domain.Account;

import java.util.List;

/**
 * Account的业务层接口
 */
public interface IAccountService {

    /**
     * 查询所有用户的方法
     */
    public List<Account> findAll();

    /**
     * 保存用户的方法
     */
    public void saveAccount(Account account);

    /**
     * 银行转账案例
     */
    public void transfer(String outAccount,String inAccount,Double money);
}
