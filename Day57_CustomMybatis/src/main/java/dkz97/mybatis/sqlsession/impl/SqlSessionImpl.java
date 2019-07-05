package dkz97.mybatis.sqlsession.impl;

import dkz97.mybatis.cfg.Configuration;
import dkz97.mybatis.sqlsession.SqlSession;
import dkz97.mybatis.sqlsession.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession的实现类
 */
public class SqlSessionImpl implements SqlSession {


    private Configuration cfg;
    private Connection connection;

    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象，根据传入的类创建代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        //创建代理对象,代理谁就用谁的加载器，
        // 参数1 ， 需要代理对象的类加载器  参数2， 需要代理对象的数组,   参数3  InvocationHandler，就是代理对象(),那个对象里面有代理方法
        Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
        return null;
    }


    /**
     * 用于关闭资源
     */
    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
