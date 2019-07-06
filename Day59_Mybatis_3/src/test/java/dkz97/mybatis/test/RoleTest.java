package dkz97.mybatis.test;

import dkz97.dao.RoleDao;
import dkz97.domain.Role;
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

public class RoleTest {

    private static InputStream is = null;
    private static SqlSession session = null;
    private static RoleDao roleDao = null;


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
        roleDao = session.getMapper(RoleDao.class);

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
     * 查询所有角色
     */
    @Test
    public void testFindAll() {

        List<Role> Roles = roleDao.findAll();
        for (Role role : Roles) {
            System.out.println(role);
        }
    }

    /**
     * 使用多表查询，查询所有用户，但是包含角色信息
     */
    @Test
    public void testFindUserByRole() {

        List<User> users = roleDao.findUserByRole();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

}

