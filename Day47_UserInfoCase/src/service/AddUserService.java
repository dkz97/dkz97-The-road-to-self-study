package service;

import domain.User;

import java.sql.SQLException;

public interface AddUserService {

    public void addUser(User user) throws SQLException;
}
