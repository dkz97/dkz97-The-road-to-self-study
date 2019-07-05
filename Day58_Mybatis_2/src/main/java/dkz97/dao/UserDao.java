package dkz97.dao;

import dkz97.domain.User;

import java.util.List;

/**
 * UserDao的接口
 */
public interface UserDao {

    /**
     * 查询所有用户的所有信息
     */
    public List<User> findAll();

    /**
     * 根据id查询用户
     */
    public User findById(int userId);

    /**
     * 保存用户
     */
    public void saveUser(User user);

    /**
     * 修改用户
     */
    public void updateUser(User user);


    /**
     * 根据用户id删除用户
     */
    public void deleteUser(Integer id);

    /**
     * 传入用户，进行模糊查询
     */
    public List<User> findByName(String username);

    /**
     * 查询总记录条数
     */
    public int findTotal();
}
