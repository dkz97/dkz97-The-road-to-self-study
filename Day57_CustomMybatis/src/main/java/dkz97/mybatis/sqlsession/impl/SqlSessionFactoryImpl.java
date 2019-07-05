package dkz97.mybatis.sqlsession.impl;


import dkz97.mybatis.cfg.Configuration;
import dkz97.mybatis.sqlsession.SqlSession;
import dkz97.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory的实现类
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {


    /**
     * 创建configuration对象，并且从构造方法中传入
     */
    private Configuration cfg;

    public SqlSessionFactoryImpl(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库的核心对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new SqlSessionImpl(cfg);
    }

}
