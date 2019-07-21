package dkz97;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Spring框架的自定义配置类
 */

/**
 * 第一个为告诉别人这个类是配置类
 * 第二个为告诉别人注解要扫描的包
 */
@Configuration
@ComponentScan(value = "dkz97")
@PropertySource(value = {"classpath:DataSource.properties"})
public class SpringConfiguration {

    /**
     * 使用el表达式进行配置，并且properties文件已经使用注解导入了
     */
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;


    /**
     * 通过注解，使方法的返回值，返回对象到ioc容器中
     *      方法中的参数会自动根据ioc容器的对象进行注入
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    public QueryRunner createRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }


    /**
     * 进行数据源的配置
     */
    @Bean(name = "dataSource")
    public DataSource createDatasource() {

        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
