package dkz97.dao;

import dkz97.domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户
     */
    public List<Account> findAll();


    /**
     * 根据uid查询所有账户
     */
    public List<Account> findByUid(Integer uid);
}
