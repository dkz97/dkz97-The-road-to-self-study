package dkz97.mybatis.sqlsession.impl;

import dkz97.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtil {

    private static Connection connection;

    /**
     * 用于获取一个连接对象
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) {


        try {
            // Class.forName，传入的是com.mysql.jdbc.Driver，主要是把mysql加载到jvm中，注册驱动
            Class.forName(cfg.getDriver());

            // 使用最基本的连接数据库的jdbc方式，DriverManger.getConnection()方法可以获取connection对象，传入的是url地址，账号，密码
            // jdbc:mysql://localhost:3306/day57 可以直接在cfg中获取当前所需要的地址
            connection = DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
