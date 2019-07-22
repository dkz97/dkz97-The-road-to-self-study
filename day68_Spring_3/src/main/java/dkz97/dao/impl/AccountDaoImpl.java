package dkz97.dao.impl;

import dkz97.dao.AccountDao;
import dkz97.domain.Account;
import dkz97.utils.ConnectionUtils;
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

    /**
     * 添加一个connectionUtils，然后可以获取connection对象，而不是靠ioc
     * @param runner
     */
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }


    public List<Account> findAll() {
        List<Account> accounts = null;
        try {
            accounts = runner.query(connectionUtils.getThreadConnection(),"SELECT * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public Account findById(Integer id) {
        Account account = null;
        try {
            account = runner.query(connectionUtils.getThreadConnection(),"SELECT * FROM account WHERE id = ?",new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public void updateAccount(Account account) {

        try {
            runner.update(connectionUtils.getThreadConnection(),"update account set name = ?, money = ? WHERE id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveAccount(Account account) {

        try {
            runner.update(connectionUtils.getThreadConnection(),"INSERT INTO account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(Integer id) {

        try {
            runner.update(connectionUtils.getThreadConnection(),"DELETE FROM account WHERE id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Account findByName(String username) {
        List<Account> accounts = null;
        try {
            accounts = runner.query(connectionUtils.getThreadConnection(),"SELECt * FROM account where name = ?",new BeanListHandler<Account>(Account.class),username);
            // 当这个账户不存在的时候的时候，就返回null
            if (accounts == null || accounts.size() == 0){
                return null;
            }
            // 当这个账户不是唯一的时候,抛出异常，告诉不是唯一
            if (accounts.size() > 1) {
                throw new Exception("该账号不是唯一，数据有问题");
            }
            // 数据正常就可以返回
            return accounts.get(0);
        } catch (Exception e) {
            // 这个抛出一个运行期异常的话，就是出现异常这个方法也不会执行了
            throw new RuntimeException(e);
        }
    }


}
