package dkz97.service;

import dkz97.domain.Account;

import java.awt.*;
import java.util.List;

/**
 * Account的业务层接口
 */
public interface AccountService {

    /**
     * 查询所有用户的方法
     */
    public List<Account> findAll();

    /**
     * 查询当个用户的方法
     */
    public Account findById(Integer id);

    /**
     * 保存用户的方法
     */
    public void saveAccount(Account account);

    /**
     * 更新用户的方法
     */
    public void updateAccount(Account account);

    /**
     * 根据id删除用户
     */
    public void deleteAccount(Integer id);
    /**
     * 银行转账案例
     */
    public void transfer(String outAccount,String acceAccount,int money);
}
