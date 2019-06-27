package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    // 定义一个连接池对象
    private static DataSource ds = null;


    static{

        // 获取配置文件对象
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
            // 获取数据库连接池
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    // 一个返回连接池对象的方法
    public static DataSource getDataSrouce() {
        return ds;
    }

    // 返回连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
