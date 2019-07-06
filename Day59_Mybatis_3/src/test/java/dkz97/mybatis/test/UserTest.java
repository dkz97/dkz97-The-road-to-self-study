package dkz97.mybatis.test;

import dkz97.dao.UserDao;
import dkz97.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserTest {

    private static InputStream is = null;
    private static SqlSession session = null;
    private static UserDao userDao =null;


    /**
     * 开始之前先获取sqlSession对象
     */
    @Before
    public void init() throws Exception{
        // 读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 使用SqlSessionFactoryBuilder 的方法来获取SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        // openSession获取SqlSession
        session = sessionFactory.openSession();

        // 创建代理对象
        userDao = session.getMapper(UserDao.class);

    }

    /**
     * 提交事务和关闭资源
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
     * 测试查询所有方法
     */
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user :users) {
            System.out.println(user);
        }
    }

    /**
     * 测试根据user的姓名和地址进行查询
     */
    @Test
    public void testFindByUser() {
        User user = new User();
        user.setUsername("杨和苏");

        List<User> users = userDao.findByUser(user);

        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * 测试根据传入的数组进行 多条件In查询
     */
    @Test
    public void testFindByList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);

        List<User> users = userDao.findByList(list);
        for (User user : users) {
            System.out.println(user);
        }


    }
}
