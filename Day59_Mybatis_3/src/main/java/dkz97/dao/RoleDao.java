package dkz97.dao;

import dkz97.domain.Role;
import dkz97.domain.User;

import java.util.List;

public interface RoleDao {

    /**
     * 查询所有角色
     */
    public List<Role> findAll();

    /**
     * 使用多表查询，查询多个用户所对应的角色
     */
    public List<User> findUserByRole();
}
