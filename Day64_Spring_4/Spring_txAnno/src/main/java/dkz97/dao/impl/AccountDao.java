package dkz97.dao.impl;


import dkz97.dao.IAccountDao;
import dkz97.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户表的持久层的实体类,使用的是jdbc的方法
 */
@Repository("accountDao")
public class AccountDao implements IAccountDao {

    // 使用的是jdbc操作数据库
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 寻找所有账户
     * @return
     */
    public List<Account> findAll() {
        List<Account> accounts = jdbcTemplate.query("SELECT * FROM account", new BeanPropertyRowMapper<Account>(Account.class));
        return accounts;
    }

    /**
     * 根据名称查找账户
     * @return
     */
    public Account findByName(String name) {
        List<Account> accounts = jdbcTemplate.query("SELECT * FROM account WHERE name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        // 判断，看account是否唯一
        if (accounts == null || accounts.size() == 0){
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("数据错误，账户名称多于1");
        }
        return accounts.get(0);
    }

    /**
     * 更新账户
     * @param account
     */
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?,money = ? WHERE id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
