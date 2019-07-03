package dkz97.dao.Impl;

import com.alibaba.druid.util.JdbcUtils;
import dkz97.dao.UserDao;
import dkz97.domain.User;
import dkz97.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    // 首先先获取template这个对象，使用jdbcutils工具包获得数据连接池
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<String> findByUsername() {

        List<String> strings = null;
        try {
            // 定义查询Username的sql语句
            String sql = "SELECT USERNAME FROM tab_user";

            // 查询username那一列的数据
            strings = template.queryForList(sql, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }

    @Override
    public int save(User user) {
        // 定义存储数据的sql，将对象存储到数据库中
        String sql = "INSERT INTO tab_user(username,password,name,birthday,sex,telephone,email,status,code) values (?,?,?,?,?,?,?,?,?)";
        System.out.println(user);
        // 将对象存储到数据库中并且返回影响的行数来判断是否注册成功
        int update = template.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode());
        return update;
    }


    // 根据激活码查询是否存在这个用户
    @Override
    public User findByCode(String code) {

        User user = null;
        // 设置try，catch，防止找不到的时候报错
        try {
            String sql = "SELECT * FROM tab_user WHERE code=?";

            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
            return user;
        } catch (Exception e) {

        }
        return user;
    }

    // 修改用户的激活状态
    @Override
    public int updateUserStatus(User user) {

        String sql = "UPDATE tab_user set status = 'Y' WHERE uid = ?";

        int update = template.update(sql, user.getUid());
        return update;
    }

    // 根据账户名和密码查询用户
    @Override
    public User findByUsername_Password(User login_user) {
        User user = null;
        //防止找不到报错就先try catch
        try {
            String sql = "SELECT * FROM tab_user WHERE username=? and password=?";

            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), login_user.getUsername(), login_user.getPassword());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
