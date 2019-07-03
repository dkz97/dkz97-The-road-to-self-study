package java;

import dkz97.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserText {

    @Test
    public void textJdbc() {
        DataSource ds = JDBCUtils.getDataSource();
        System.out.println(ds);
        JdbcTemplate template = new JdbcTemplate(ds);

        System.out.println(template);

    }
}
