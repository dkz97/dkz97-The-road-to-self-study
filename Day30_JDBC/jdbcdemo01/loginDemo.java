package Day30_JDBC.jdbcdemo01;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class loginDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入账号");
        String name = sc.nextLine();
        System.out.print("输入密码");
        String psd = sc.nextLine();
        login(name,psd);
    }

    public static void login(String name, String password) {
        // 利用自定义工具注册驱动和获取connection对象
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;

        try {
            // 获取对象
            conn = JdbcUtils.getConnection();

            // 获取执行SQl语句对象
            sttm = conn.createStatement();

            // 写sql语句
            String sql = "SELECT * FROM information WHERE username='" + name + "'and password1='" + password + "'";

            // 执行sql语句
            rs = sttm.executeQuery(sql);


            if (rs.next()) {
                System.out.println("登陆成功");
            } else {
                System.out.println("登陆失败");
            }
            String st = rs.getString(2);
            System.out.println(st);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,sttm,rs);
        }
    }

}
