package dkz97.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 关于事务操作的工具类，对事务的提交回滚等
 * 对于事务，就需要获取connection
 */
public class TransactionManager {

    // 获取connection工具类，就可以获取connection连接，就可以使用事务
    private ConnectionUtils connectionUtils;

    // 使用ioc容器进行注入
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransacation(){

        try {
            Connection connection = connectionUtils.getThreadConnection();

            // setAutoCommit,关闭自动提交事务，就是开启事务
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {

        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release(){

        try {
            // 这个连接会进行关闭，会还回到池里面去，但是在线程中还会显示有连接，但是呢，连接是不能用的，所以需要在线程中移除
            connectionUtils.getThreadConnection().close();
            connectionUtils.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
