package dkz97.test.Account;


import dkz97.dao.IAccountDao;
import dkz97.domain.Account;
import dkz97.service.impl.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testSpring() {
        accountService.findAll();
    }

    /**
     * 测试基本的mybatis
     * @throws IOException
     */
    @Test
    public void testMybatis() throws IOException {
        // 加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 根绝FactoryBuilder获取工厂类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 创建dao的代理对象，然后就可以调用方法
        IAccountDao acc = sqlSession.getMapper(IAccountDao.class);


        Account account = new Account();
        account.setName("李四");
        account.setMoney(30);
        // 需要手动提交
        sqlSession.commit();
        acc.saveAccount(account);

        sqlSession.close();
        is.close();
    }
}
