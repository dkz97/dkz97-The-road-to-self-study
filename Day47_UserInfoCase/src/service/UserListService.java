package service;


import domain.User;

import java.sql.SQLException;
import java.util.List;

// 这个是用来查询用户列表的接口
// 调用的是 查询所有用户的方法
public interface UserListService {

    public List<User> findAll() throws SQLException;

}
