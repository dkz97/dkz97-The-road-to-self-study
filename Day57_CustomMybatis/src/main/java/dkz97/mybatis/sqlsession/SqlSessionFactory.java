package dkz97.mybatis.sqlsession;


/**
 * 创建sqlSession的接口对象
 */
public interface SqlSessionFactory {


    public SqlSession openSession();

}
