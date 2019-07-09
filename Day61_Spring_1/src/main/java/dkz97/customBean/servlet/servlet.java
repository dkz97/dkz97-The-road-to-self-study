package dkz97.customBean.servlet;

import dkz97.customBean.Bean.BeanFactory;
import dkz97.customBean.service.UserService;

public class servlet {


    //private static UserService userService = new UserServiceImpl();

    // 使用Bean类获取userService，进行解耦
    private static UserService userService;

    static {
        try {
            userService = (UserService) BeanFactory.getBean("UserService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 模仿三层架构的web层
     */
    public static void main(String[] args) {
        userService.saveUser();
    }

}
