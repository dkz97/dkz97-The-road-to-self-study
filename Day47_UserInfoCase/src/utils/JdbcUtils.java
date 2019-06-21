package utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

// 一个jdbc的工具包，可以提供连接池和链接对象
public class JdbcUtils {

    static DataSource ds = null;


    // 使用静态代码块获取连接池
    static {
        try {
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties ps = new Properties();
            ps.load(resourceAsStream);

            ds = DruidDataSourceFactory.createDataSource(ps);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    // 提供连接池对象
    public static DataSource getDataSource() {
        return ds;
    }


    // 提供连接connection
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
