package Session.atuh_code_demo;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

// 专门用来写操作数据库语句的
public class UserDo {

    // 获取连接池对象
    static DataSource ds = JdbcUtils.getDataSource();
    static JdbcTemplate template = new JdbcTemplate(ds);

    // 设置一个方法，可以查询账号密码的语句
    public static User login(User login_user) {
        // 定义sql语句
        String sql = "SELECT * FROM Login WHERE username=? and password=?";

        // 通过查询语句封装成bean对象
        try {
            User user = template.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    login_user.getUsername(),
                    login_user.getPassword()
            );
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
