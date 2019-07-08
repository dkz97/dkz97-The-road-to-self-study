package dkz97.mybatis.test;

import dkz97.dao.AccountDao;
import dkz97.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private static InputStream is;
    private static SqlSession session;
    private static AccountDao accountDao;

    /**
     * 提前加载资源
     */
    @Before
    public void init() throws Exception{
        //1. 加载主配置资源
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取sqlseesion工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3.获取SqlSession对象
        session = factory.openSession();
        // 4.获取Dao代理对象
        accountDao = session.getMapper(AccountDao.class);

    }

    /**
     * 提交事务和关闭资源
     */
    @After
    public void destory() throws Exception{
        // 提交事务
        session.commit();

        //关闭资源
        session.close();
        is.close();
    }


    /**
     * 查询所有账户的,并且查询用户信息
     */
    @Test
    public void testFindAll() {

        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
//            System.out.println(account);
//            System.out.println(account.getUser());
            // 使用延迟加载的方法
            System.out.println(account.getMoney());
        }
    }



}
