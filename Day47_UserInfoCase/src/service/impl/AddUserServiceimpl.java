package service.impl;

import dao.impl.UserDoimpl;
import domain.User;
import service.AddUserService;

import java.sql.SQLException;

public class AddUserServiceimpl implements AddUserService {
    @Override
    public void addUser(User user) throws SQLException {
        // 调用dao
        UserDoimpl add = new UserDoimpl();

        add.addUser(user);
    }
}
