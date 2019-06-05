package Day30_JDBC.Database_ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DruidJdbcUtilsDemo01 {

    public static void main(String[] args) throws Exception {
        Connection conn = DruidJdbcUtils.getConnection();
        String sql = "SELECT * FROM emp";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        String username = rs.getString(2);
        System.out.println(username);
        DruidJdbcUtils.close(conn,pstmt,rs);
    }

}
