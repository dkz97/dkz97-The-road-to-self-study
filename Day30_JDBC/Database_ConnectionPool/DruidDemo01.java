package Day30_JDBC.Database_ConnectionPool;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/*
1. 导入jar包 druid-1.0.9.jar
2. 定义配置文件：
	* 是properties形式的
	* 可以叫任意名称，可以放在任意目录下
3. 加载配置文件。Properties
4. 获取数据库连接池对象：通过工厂类来获取  DruidDataSourceFactory
5. 获取连接：getConnection
*/
public class DruidDemo01 {

    public static void main(String[] args) throws Exception {

        // 定义配置文件
            // 先创建类加载器，然后使用类加载器的方法寻找properties这个文件路径，然后创建properties对象，然后把druid的properties文档load到对象中
            // properties对象主要是放入文件的文件路径的流，为什么不用Inputstream，因为input流需要绝对路径，类加载器不用
            // 流加载器如何获取，就用类对象来加载就行，类对象可以直接用当前类
        InputStream is = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties ps = new Properties();
        ps.load(is);

        DataSource ds = DruidDataSourceFactory.createDataSource(ps);
        Connection conn = ds.getConnection();

    }
}
