package Day30_JDBC.Database_ConnectionPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/*1. 导入jar包
2. 创建JdbcTemplate对象。依赖于数据源DataSource
	* JdbcTemplate template = new JdbcTemplate(ds);
3. 调用JdbcTemplate的方法来完成CRUD的操作
	* update():执行DML语句。增、删、改语句
	* queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
		* 注意：这个方法查询的结果集长度只能是1
	* queryForList():查询结果将结果集封装为list集合
		* 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
	* query():查询结果，将结果封装为JavaBean对象
		* query的参数：RowMapper
			* 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
			* new BeanPropertyRowMapper<类型>(类型.class)
		* queryForObject：查询结果，将结果封装为对象
			* 一般用于聚合函数的查询*/
public class SpringJDBCdemo {

    private static JdbcTemplate template = null;
    @Before
    public void main() {
        try {
            // 获取连接池
            InputStream is = SpringJDBCdemo.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties ps = new Properties();
            ps.load(is);
            // Druid传入的是pro配置文件
            DataSource ds = DruidDataSourceFactory.createDataSource(ps);
            // 创建jdbcTemplate对象，需要传入DataSource，连接池
            template = new JdbcTemplate(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 定义sql语句
            /*需求：
				1. 修改1号数据的 salary 为 10000
				2. 添加一条记录
				3. 删除刚才添加的记录
				4. 查询id为1的记录，将其封装为Map集合
				5. 查询所有记录，将其封装为List
				6. 查询所有记录，将其封装为Emp对象的List集合
				7. 查询总记录数*/
    }
    @Test
    public void text(){
        String sql = "UPDATE emp set salary = 10000 WHERE id = ?";
        template.update(sql,1);
    }

    @Test
    public void testAdd() {
        String sql = "Insert into emp (id,name,salary) values (?,?,?)";
        int i = template.update(sql,10,"bailon",5);
        System.out.println(i);
    }
    @Test
    public void deleteAdd() {
        String sql = "delete from emp WHERE id = ?";
        template.update(sql,9);
    }
    @Test
    public void printMap() {
        String sql = "SELECT * FROM emp WHERE id = ?";
        Map<String, Object> map = template.queryForMap(sql,1);
        System.out.println(map);
    }
    @Test
    public void pirintList() {
        String sql = "Select * From emp";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
    @Test
    public void query() {
        String sql = "Select * from emp";
        // BeanPropertyRowMapper会直接将表模版的字节码给封装
        BeanPropertyRowMapper<db3Demo> db3DemoBeanPropertyRowMapper = new BeanPropertyRowMapper<>(db3Demo.class);

        List<db3Demo> list = template.query(sql,db3DemoBeanPropertyRowMapper);
        for (db3Demo db3Demo : list) {
            System.out.println(db3Demo);
        }
    }
    @Test
    public void tses() {
        String sql = "select count(id) from emp";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println(aLong);

    }







}
