package service.impl;

import dao.impl.UserDoimpl;
import domain.User;
import service.UserListService;

import java.sql.SQLException;
import java.util.List;

public class UserListServiceimpl implements UserListService {


    @Override
    public List<User> findAll() throws SQLException {
        // 可以查询所有的列表
        UserDoimpl findAllimpl = new UserDoimpl();
        List<User> users = findAllimpl.findAll();
        return users;
    }
}
