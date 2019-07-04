package dkz97.dao;


import dkz97.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * UserDao
 * 主要是用来设置 查询，curd User表的
 */
public interface UserDao {

    /**
     * 查询所有账户
     */
    //@Select("SELECT * FROM user") 注解配置
    public List<User> findAll();
}
