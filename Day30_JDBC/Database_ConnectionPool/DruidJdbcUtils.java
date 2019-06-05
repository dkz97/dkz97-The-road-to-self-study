package Day30_JDBC.Database_ConnectionPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// 定义一个Druid的线程池工具类，可以自动创建线程池，有关闭连接的方法，有获取连接池的方法
public class DruidJdbcUtils {

    private static DataSource ds;

    // 自动创建线程池对象
    static {
        InputStream is = DruidJdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties ps = new Properties();

        try {
            // 将硬件内的properties配置文件，加载到ps对象中
            ps.load(is);
            // 获取数据库连接池对象，然后就将ps文件传入
            ds = DruidDataSourceFactory.createDataSource(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 返回connection对象的方法
    public static Connection getConnection() throws Exception {
        // 返回连接对象的话，直接用连接池的getConnection方法就ok
        return ds.getConnection();
    }

    //关闭流对象，Statement, connection,ResultSet
    public static void close(Connection conn, Statement sttm) {

        if (sttm != null) {
            try {
                sttm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection coon, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        close(coon,stmt);
    }


}
