package dkz97.mybatis.sqlsession;


import dkz97.mybatis.cfg.Configuration;
import dkz97.mybatis.sqlsession.impl.SqlSessionFactoryImpl;
import dkz97.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个sqlSession对象
 * 重写一个builder的方法
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流，构建一个sqlSessionFactory
     * @param is
     * @return
     */
    public SqlSessionFactory build(InputStream is) {

        Configuration configuration = XMLConfigBuilder.loadConfiguration(is);



        return new SqlSessionFactoryImpl(configuration);
    }


}
