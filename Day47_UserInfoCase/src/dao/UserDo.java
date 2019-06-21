package dao;

import domain.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDo {

    public User login(User user);
    public List<User> findAll() throws SQLException;
    public void addUser(User user) throws SQLException;
    public void deleteUser(int i);
    public User findId(int i);
    public void updateUser(User user);
    public int findTotalCount(Map<String, String[]> condition);
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
