package dkz97.mybatis.sqlsession;


/**
 * 可以使用一个方法，产生代理对象的
 * 自定义mybatis和数据库交互的核心类
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);


    /**
     * 关闭接口资源
     */
    void close();



}
