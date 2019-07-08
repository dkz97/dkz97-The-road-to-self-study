package dkz97.dao;

import dkz97.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户，并且带有用户信息
     */
    @Select("SELECT * FROM account")
    @Results(id = "findAccount",value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "dkz97.dao.UserDao.findById",fetchType = FetchType.LAZY))
    })
    public List<Account> findAll();


    /**
     * 根据uid查询所有账户
     */
    @Select("SELECT * FROM account WHERE uid=#{uid}")
    public List<Account> findByUid(Integer uid);


}
