package dkz97.service;

import dkz97.domain.Account;

import java.util.List;

/**
 * 账户表的业务层service接口
 */
public interface IAccountService {

    /**
     * 查询所有账户的方法
     */
    public List<Account> findAll();

    /**
     * 银行转账案例
     */
    public void transfer(String outAccount,String intoAccount,int money);
}
