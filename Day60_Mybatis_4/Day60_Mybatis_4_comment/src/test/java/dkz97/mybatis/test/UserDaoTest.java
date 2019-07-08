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
import java.util.List;

public class UserDaoTest {

    private static InputStream is;
    private static SqlSession session;
    private static UserDao userDao;

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
        userDao = session.getMapper(UserDao.class);

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
     * 查询所有用户的方法
     */
    @Test
    public void testFindAll() {

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 根据用户id查询结果
     */
    @Test
    public void testFindById() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    /**
     * 保存用户
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("王五");
        user.setUserAddress("广州");
        user.setUserSex("男");

        userDao.saveUser(user);
    }

    /**
     * 根据id修改用户
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUserId(46);
        user.setUserName("刘炫廷");
        user.setUserAddress("墨尔本");

        userDao.updateUser(user);
    }
}
