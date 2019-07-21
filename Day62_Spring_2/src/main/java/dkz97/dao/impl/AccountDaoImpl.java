package dkz97.dao.impl;

import dkz97.dao.AccountDao;
import dkz97.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户持久层dao的实现类
 */
public class AccountDaoImpl implements AccountDao {

    /**
     * 持久层技术使用的是DBUtils 所以直接使用
     * @return
     */
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }


    public List<Account> findAll() {
        List<Account> accounts = null;
        try {
            accounts = runner.query("SELECT * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public Account findById(Integer id) {
        Account account = null;
        try {
            account = runner.query("SELECT * FROM account WHERE id = ?",new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public void updateAccount(Account account) {

        try {
            runner.update("update account set name = ?, money = ? WHERE id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveAccount(Account account) {

        try {
            runner.update("INSERT INTO account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(Integer id) {

        try {
            runner.update("DELETE FROM account WHERE id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
