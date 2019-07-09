package dkz97.springCase;

import dkz97.customBean.service.UserService;
import dkz97.springCase.service.impl.UserServiceImpl;

public class staticfactory {

    public UserServiceImpl getService() {
        return new UserServiceImpl();
    }

    public static UserServiceImpl getServiceStatic() {
        return new UserServiceImpl();
    }

}
