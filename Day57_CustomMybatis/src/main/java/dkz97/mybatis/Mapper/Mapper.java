package dkz97.mybatis.Mapper;

/**
 * mybatis自定义的配置类
 * 主要是用于存放映射信息的配置类的
 * 封装sql语句，和结果类型的全类名称
 *
 */
public class Mapper {

    private String queryString;
    private String resultType;



    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
