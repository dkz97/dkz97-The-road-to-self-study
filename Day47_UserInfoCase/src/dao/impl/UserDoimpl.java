package dao.impl;

import dao.UserDo;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDoimpl implements UserDo {

    DataSource ds = JdbcUtils.getDataSource();
    JdbcTemplate template = new JdbcTemplate(ds);


    @Override
    public void addUser(User user){
        // 添加的时候设置编码，防止乱码
        String sql = "INSERT INTO user(name,gender,age,address,qq,email) value (?,?,?,?,?,?)";

        // 获取sql语句并且 设置属性
        int update = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        // 根据id来删除对应的对象

        String sql = "DELETE FROM user WHERE id=?";
        int update = template.update(sql, id);
    }

    @Override
    public User findId(int i) {
        String sql = "SELECT * FROM user WHERE id=?";

        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), i);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name=?, gender=?,age=?,address=?,qq=?,email=? WHERE id=?";

        int update = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user WHERE 1=1";
        StringBuilder sb = new StringBuilder(sql);

        // 定义参数的集合
        List<Object> parmas = new ArrayList<>();
        // 定义一个加问号条件参数的值，一个列表可以直接放到下面的方法进行传参
        Set<String> strings = condition.keySet();

        for (String string : strings) {
            // 排除分页查询的参数
            if("currentPage".equals(string) || "rows".equals(string)){
                continue;
            }
            String value = condition.get(string)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and " + string + " like ? ");
                parmas.add("%" + value+ "%");
            }
        }
        sql = sb.toString();

        Integer integer = template.queryForObject(sql, Integer.class,parmas.toArray());
        return integer;
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "SELECT * FROM user WHERE 1=1 ";
        StringBuilder sb = new StringBuilder(sql);

        // 定义参数的集合
        List<Object> parmas = new ArrayList<>();
        // 定义一个加问号条件参数的值，一个列表可以直接放到下面的方法进行传参
        Set<String> strings = condition.keySet();

        for (String string : strings) {
            // 排除分页查询的参数
            if("currentPage".equals(string) || "rows".equals(string)){
                continue;
            }
            String value = condition.get(string)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and " + string + " like ? ");
                parmas.add("%" + value+ "%");
            }
        }
        sb.append(" limit ?, ?;");
        sql = sb.toString();
        parmas.add(start);
        parmas.add(rows);
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class),parmas.toArray());
        return list;
    }



    @Override
    public List<User> findAll() throws SQLException {
        // 通过jdbc工具包获取连接池，再通过连接池来与数据库进行联系的操作,使用BeanUtils来封装成User类

        String sql = "SELECT * FROM user";

        // 创建JdbcTemplate类

        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User login(User login_user) {
        //定义sql
        String sql = "SELECT * FROM user WHERE username=? and password=?";

        try {
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    login_user.getUsername(),
                    login_user.getPassword()
            );
            return user;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
