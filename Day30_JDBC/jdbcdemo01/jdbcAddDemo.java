package Day30_JDBC.jdbcdemo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 用jdbc进行添加
public class jdbcAddDemo {

    public static void main(String[] args) {
        Connection conn = null;
        Statement sttm = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取connection对象
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db3","root","pzr980716");
            // 定义sql语句
            String sql = "INSERT INTO emp (name,gender,salary,join_date) values ('白龙马','男',5000,'2012-03-01,2')";
            // 获取执行sql语句的对象statement
            sttm = conn.createStatement();
            // 执行sql语句
            int i = sttm.executeUpdate(sql);
            if ( i > 0) {
                System.out.println("添加成功");
            }
            else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (sttm != null) {
                try {
                    sttm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
