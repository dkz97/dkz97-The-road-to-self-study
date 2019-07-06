package dkz97.dao;

import dkz97.domain.Account;
import dkz97.domain.AccountUser;
import dkz97.domain.User;

import java.util.List;

public interface AccountUserDao {

    /**
     * 查询一对多的关系,使用多个查询，让两个表的关系连接起来，然后返回一个新的AccountUser类
    List<AccountUser> findAll();
     */



    /**
     * 将user类设置在Account类中成为属性，查询到account的时候也能把用户封装在属性里面
     */
    List<Account> findAll();


    /**
     * 一对多的查询关系，主表实体应该包含从表实体的集合类
     */
    List<User> findAllUser();
}


