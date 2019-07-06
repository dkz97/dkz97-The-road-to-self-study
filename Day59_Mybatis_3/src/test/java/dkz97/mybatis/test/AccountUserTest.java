package dkz97.mybatis.test;

import dkz97.dao.AccountUserDao;
import dkz97.domain.Account;
import dkz97.domain.AccountUser;
import dkz97.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountUserTest {

    private static InputStream is = null;
    private static SqlSession session = null;
    private static AccountUserDao accountUserDao = null;


    /**
     * 提早加载资源
     */
    @Before
    public void init() throws Exception{
        // 1. 加载配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 3. 获取SqlSession的对象
        session = sqlSessionFactory.openSession();
        // 4. 创建代理对象
        accountUserDao = session.getMapper(AccountUserDao.class);

    }

    /**
     * 最后提交事务和关闭资源
     */
    @After
    public void destory() throws Exception{
        // 提交事务
        session.commit();

        // 关闭资源
        session.close();
        is.close();
    }



    /**
     * 查询多对一表查询所有的方法  从表中包含主表类
     */
    @Test
    public void testFindAll() {

        List<Account> accounts = accountUserDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 查询一对多的方法，主表中包含从表的列表
     */
    @Test
    public void testFindAllUser() {

        List<User> users = accountUserDao.findAllUser();

        for (User user : users) {
            System.out.println(user);
            List<Account> accounts = user.getAccounts();
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
    }

}
