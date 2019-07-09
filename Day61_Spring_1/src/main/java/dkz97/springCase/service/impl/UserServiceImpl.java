package dkz97.springCase.service.impl;

import dkz97.springCase.dao.UserDao;
import dkz97.springCase.dao.impl.UserDaoImpl;
import dkz97.springCase.service.UserService;

public class UserServiceImpl implements UserService {


    UserDao userDao = new UserDaoImpl();

    private int age;



    public UserServiceImpl getBean() {
        return new UserServiceImpl();
    }

    /**
     * 模仿三层架构的业务层保存用户,调用Dao
     */
    public void saveUser() {

        userDao.saveUser();
    }



}
