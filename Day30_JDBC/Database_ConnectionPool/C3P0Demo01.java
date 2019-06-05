package Day30_JDBC.Database_ConnectionPool;

// c3p0 演示
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo01 {

    public static void main(String[] args) throws SQLException {
        // 创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 在连接池中拿连接对象
        Connection conn = ds.getConnection();
        System.out.println(conn);

        // 释放资源
        conn.close();
    }

}
