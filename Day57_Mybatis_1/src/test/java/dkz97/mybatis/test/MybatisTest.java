package dkz97.mybatis.test;

import dkz97.dao.UserDao;
import dkz97.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    /**
     * mybatis入门的案例
     *
     */

    public static void main(String[] args) throws Exception{
        //1.首先要读取自己设置sqlMapConfig配置文件,主要是使用配置文件的读取方法
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 2.创建sqlSessionFactory工厂，但是首先要创建工厂的builder,然后再创建工厂类，并且传入配置文件的流
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);

        // 3.使用工厂对象的openSession方法获取sqlSession对象
        SqlSession session = factory.openSession();

        // 4.使用SqlSession对象，获取Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);

        // 5.然后代理对象就可以执行 类下面有的方法
        List<User> users = userDao.findAll();

        for (User user:users) {
            System.out.println(user);
        }

        // 6.释放资源
        session.close();
        resourceAsStream.close();

    }
}
