package dkz97.service;

import dkz97.domain.User;

import java.util.List;

public interface UserService {


    /*
    * 注册方法
    *   主要调用两个dao
    *
    * */
    public boolean register(User user);


    /*
    *   验证激活状态的方法
    *
    * */
    boolean checkCode(String code);


    /*
    *   登陆方法
    * */
    public User login(User user);
}
