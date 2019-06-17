package Session.atuh_code_demo;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

// jdbc的工具类，可以返回连接池对象和connection对象
public class JdbcUtils {

    public static DataSource ds;


    static {
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // 返回连接池对象
    public static DataSource getDataSource() {
        return ds;
    }

    // 返回连接connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
