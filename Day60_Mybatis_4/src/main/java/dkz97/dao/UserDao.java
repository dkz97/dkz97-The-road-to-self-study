package dkz97.dao;

import dkz97.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 使用注解的方式来进行开发
 */
public interface UserDao {

    /**
     * 查询所有User的方法,
     */
    public List<User> findAll();


    /**
     * 根据id查询用户
     */
    public User findById(Integer id);
}
