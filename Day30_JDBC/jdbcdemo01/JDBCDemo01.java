package Day30_JDBC.jdbcdemo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo01 {


    public static void main(String[] args) throws Exception {
        // 注册驱动，就是定义数据库的意思
        Class.forName("com.mysql.jdbc.Driver");

        // 获取数据库连接对象 Connection
       Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db3","root","pzr980716");

        // 定义要操作的sql语句
        String sql = "update emp set salary = 4000 WHERE id = 2";

        // 使用连接对象获取的可以执行sql的对象
        Statement stmt = conn.createStatement();

        // 执行sql语句并且返回结果
        int i = stmt.executeUpdate(sql);

        // 操作返回结果
        System.out.println(i);

        // 释放资源
        stmt.close();
        conn.close();

    }

}
