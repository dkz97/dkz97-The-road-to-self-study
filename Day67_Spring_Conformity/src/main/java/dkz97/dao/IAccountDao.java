package dkz97.dao;

import dkz97.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 一个account的接口类，到时候用mybatis来配置
 */
@Repository("accountDao")
public interface IAccountDao {

    /**
     * 查询所有用户的方法
     */
    public List<Account> findAll();

    /**
     * 保存用户的方法
     */
    public void saveAccount(Account account);


    /**
     * 根据名称获取账户信息
     */
    public Account findByName(String name);

    /**
     * 更新用户
     */
    public void updateAccount(Account account);
}
