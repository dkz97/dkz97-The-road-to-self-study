package Day30_JDBC.jdbcdemo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 修改数据表中的对象
public class jdbcUpdateDemo {

    public static void main(String[] args) {
        Connection conn = null;
        Statement sttm = null;

        try {
            // 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db3","root","pzr980716");
            // 定义sql语句
            String sql = "Update emp set salary = 3000 WHERE id = 5";
            // 获取Statement对象
            sttm = conn.createStatement();
            // 执行sql 语句
            int i = sttm.executeUpdate(sql);
            if (i > 0) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null ){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if ( sttm != null) {
                try {
                    sttm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
