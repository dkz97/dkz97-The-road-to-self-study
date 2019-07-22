package dkz97.utils;

import dkz97.domain.Account;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 一个connection的工具包，从数据源中获取一个连接，并且可以让对象使用连接的时候绑定只有一个connection
 */
public class ConnectionUtils {

    // 一个ThreadLocal，一个线程地址，然后泛型的话估计是填的什么，然后get()方法中，就获取当前线程的相对应的对象
    // ThreadLocal是获得当前线程
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    // 使用ioc容器中注入数据
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        try {
            //1.先从ThreadLocal中获取,connection。
            Connection connection = tl.get();
            // 2. 判断当前线程上是否有连接
            if (connection == null) {
                // 把connection存入到当前线程中
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    /**
     * 写一个remove方法，可以在线程中移除connection连接对象，主要是用于connection返回池内的时候使用解绑
     */
    public void remove(){
        tl.remove();
    }
}
