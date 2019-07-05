package dkz97.mybatis.cfg;

import dkz97.mybatis.Mapper.Mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * mybatis配置的自定义类
 * 主要是用于存放数据库的连接信息的
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String, Mapper> mappers = new HashMap<String,Mapper>();


    public Map<String, Mapper>  getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper>  mappers) {
        // 因为有多个mappers，所以需要把mappers追加进去，而不是直接赋值
        this.mappers.putAll(mappers);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
