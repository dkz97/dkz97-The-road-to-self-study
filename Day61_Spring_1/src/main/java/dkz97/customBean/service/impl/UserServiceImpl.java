package dkz97.customBean.service.impl;

import dkz97.customBean.Bean.BeanFactory;
import dkz97.customBean.dao.UserDao;
import dkz97.customBean.service.UserService;

public class UserServiceImpl implements UserService {


    //UserDao userDao = new UserDaoImpl();
    private static UserDao userDao;

    static {
        try {
            userDao = (UserDao) BeanFactory.getBean("UserDao");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 模仿三层架构的业务层保存用户,调用Dao
     */
    public void saveUser() {

        userDao.saveUser();
    }
}
