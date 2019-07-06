package dkz97.dao;

import dkz97.domain.AccountUser;
import dkz97.domain.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    /**
     * 查找所有的方法
     */
    List<User> findAll();

    /**
     * 根据传入的User类，根据类不为空的数据查询
     */
    List<User> findByUser(User user);

    /**
     * 根据传入的list数组进行in(xxx)的查询
     */
    List<User> findByList(ArrayList<Integer> list);



}
