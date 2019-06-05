package Day30_JDBC.jdbcdemo01;


import java.sql.*;

// 定义一个jdbc的工具类 需要注册驱动,释放资源,得到连接
public class JdbcUtils {

    private static final String USE = "root";
    private static final String PWD = "pzr980716";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/db3";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // 用静态代码块对其进行注册驱动,
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USE,PWD);
    }

     public static void close(Connection coon, Statement sttm, ResultSet rs) {
         if (rs != null) {
             try {
                 rs.close();
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
         if (coon != null) {
             try {
                 coon.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }


    }

}
