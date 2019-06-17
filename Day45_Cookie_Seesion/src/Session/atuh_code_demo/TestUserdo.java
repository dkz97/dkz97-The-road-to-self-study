package Session.atuh_code_demo;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Set;

public class TestUserdo {

    @Test
    public  void TestUserdo() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        User login = UserDo.login(user);
        System.out.println(login);
    }

    @Test
    public void JdbcutilTest() {
        DataSource ds = JdbcUtils.getDataSource();
        System.out.println(ds);

        JdbcTemplate template = new JdbcTemplate(ds);
        System.out.println(template);

        Map<String, Object> stringObjectMap = template.queryForMap("SELECT * FROM login");

        Set<String> strings = stringObjectMap.keySet();
        for (String string : strings) {
            System.out.println(string + "-->" + stringObjectMap.get(string));
        }

    }
}
