package dkz97.dao;

import dkz97.domain.User;

import java.util.List;

public interface UserDao {


    // 查询所有的用户名账号
    public List<String> findByUsername();

    // 注册账号保存账号的
    public int save(User user);

    // 根据激活码查询账号是是否存在
    public User findByCode(String code);

    // 修改对象的激活状态
    public int updateUserStatus(User user);

    // 查询用户和密码，看是否对得上号能否登陆
    User findByUsername_Password(User user);


}
