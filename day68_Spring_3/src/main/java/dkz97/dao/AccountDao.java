package dkz97.dao;

import dkz97.domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有
     */
    public List<Account> findAll();

    /**
     * 根据id查询单个
     */
    public Account findById(Integer id);

    /**
     * 修改用户
     */
    public void updateAccount(Account account);

    /**
     * 保存用户
     */
    public void saveAccount(Account account);

    /**
     * 删除用户
     */
    public void deleteAccount(Integer id);


    /**
     * 根据用户名称查询账户
     */
    public Account findByName(String username);


}
