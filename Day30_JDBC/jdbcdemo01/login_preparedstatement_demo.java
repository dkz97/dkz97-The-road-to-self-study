package Day30_JDBC.jdbcdemo01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class login_preparedstatement_demo {
    // 获取sttm,connection
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入账号: ");
        String username = sc.nextLine();
        System.out.print("输入密码: ");
        String password = sc.nextLine();
        new login_preparedstatement_demo().login(username,password);
    }

    public void login (String username, String password) {
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 定义sql语句
            String sql = "Select * from information where username=? and password1=?";
            // 获取preparedStatement 对象
            pstmt = conn.prepareStatement(sql);
            // 设置?值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            // 执行sql语句
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("登陆成功");
            } else {
                System.out.println("登陆失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,pstmt,rs);
        }
    }



}
