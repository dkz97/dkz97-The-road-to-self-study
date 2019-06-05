package Day30_JDBC.jdbcdemo01;

import java.sql.*;
import Day30_JDBC.jdbcdemo01.JdbcUtils;
public class jdbcDQLDemo01 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "Select * from emp";
            sttm = conn.createStatement();
            // 获取查询结果然后存储到集合中
            rs = sttm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                System.out.println(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            JdbcUtils.close(conn, sttm, rs);
        }

    }
}
