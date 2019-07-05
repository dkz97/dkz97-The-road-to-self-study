package dkz97.Mybatis.test;

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
import java.util.Date;
import java.util.List;

/**
 * 用来测试Mybatis的各种操作
 */
public class MybatisTest {


    private static SqlSession session = null;
    private static InputStream is = null;
    private static UserDao userDao = null;

    /**
     * 开始之前先加载资源
     */
    @Before
    public void init() throws Exception{
        // 1.先把配置文件的流给弄出来
        is = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 2.获得sqlSessionFactory工厂类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3.使用工厂类对象 获取sqlSession对象
        session = factory.openSession();
        // 4.使用sqlSession对象获取dao的代理对象
        userDao = session.getMapper(UserDao.class);

    }

    /**
     * 结束之后就关闭资源
     */
    @After
    public void destory() throws Exception{
        // 最后要提交事务
        session.commit();
        // 关闭资源
        session.close();
        is.close();
    }



    /**
     * 测试查询所有的方法
     */
    @Test
    public void TestfindAll() {


        // 5.调用方法，获取结果集
        List<User> users = userDao.findAll();
        // 遍历结果获得user
        for(User user:users) {
            System.out.println(user);
        }

    }

    /**
     * 测试查询一个的方法
     */
    @Test
    public void TestFindById() {
        User user = userDao.findById(48);
        System.out.println(user);

    }


    /**
     * 保存增加一个用户
     */
    @Test
    public void TestSaveUser() {
        User user = new User();
        user.setUsername("张三");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("广州市番禺区");

        System.out.println(user);
        userDao.saveUser(user);

        // 因为在配置里面加了selectkey 配置了属性，可以把id也获取
        System.out.println(user);

    }

    /**
     * 根据id修改用户
     */
    @Test
    public void TestUpdateUser() {
        User user = new User();
        user.setAddress("中国台湾");
        user.setSex("女");
        user.setUsername("杨和苏");
        user.setId(41);

        userDao.updateUser(user);
    }

    /**
     * 根据用户的id删除方法
     */
    @Test
    public void TestDeleteUser() {

        // 传入id，调用方法
        userDao.deleteUser(52);

    }

    /**
     * 根据姓名来进行模糊查询
     */
    @Test
    public void TestFindByName() {

        // 传入字符窜进行模糊查询
        // 由于模糊查询需要百分号 %% 因为select语句中没有
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询总记录条数
     */
    @Test
    public void TestFindTotal() {
        int total = userDao.findTotal();

        System.out.println(total);

    }

}
