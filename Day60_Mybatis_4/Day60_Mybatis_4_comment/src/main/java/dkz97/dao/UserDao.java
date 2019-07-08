package dkz97.dao;

import dkz97.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;


/**
 * 使用注解的方式来进行开发
 */
public interface UserDao {

    /**
     * 查询所有User的方法,并且带有账户信息
     */
    @Select("SELECT * FROM user")
    @Results(id = "userMap",value = {
            @Result(id=true, property = "userId", column = "id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "userAddress", column = "address"),
            @Result(property = "userSex", column = "sex"),
            @Result(property = "userBirthday", column = "birthday"),
            @Result(property = "userAccounts",column = "id",many = @Many(select = "dkz97.dao.AccountDao.findByUid",fetchType = FetchType.LAZY))

    })
    public List<User> findAll();

    /**
     * 根据用户id查询用户
     */
    @Select("SELECt * FROM user WHERE id = #{uid}")
    public User findById(Integer uid);

    /**
     * 保存用户
     */
    @Insert("INSERT INTO user(username,address,sex) values (#{userName},#{userAddress},#{userSex})")
    public void saveUser(User user);


    /**
     * 根绝Id修改用户
     */
    @Update("UPDATE user SET username=#{userName}, sex=#{userSex} WHERE id = #{userId} ")
    public void updateUser(User user);

}
