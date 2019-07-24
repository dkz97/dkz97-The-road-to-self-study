package dkz97.dao;

import dkz97.domain.Account;

import java.util.List;

/**
 * 账户表的持久层
 */
public interface IAccountDao {

    /**
     * 寻找全部账户
     */
    public List<Account> findAll();

    /**
     * 根据名称寻找账户
     */
    public Account findByName(String name);

    /**
     * 更新账户
     */
    public void updateAccount(Account account);
}
