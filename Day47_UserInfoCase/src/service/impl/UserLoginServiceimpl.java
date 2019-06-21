package service.impl;

import dao.impl.UserDoimpl;
import domain.User;
import service.UserLoginService;

public class UserLoginServiceimpl implements UserLoginService {


    @Override
    public User login(User login_user) {
        // 调用dao的查询语句
        User user = new UserDoimpl().login(login_user);
        return user;
    }
}
