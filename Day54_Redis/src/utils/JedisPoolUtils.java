package utils;


// 可以读取配置文件，根绝配置文件来配置连接池对象，并且有一个方法可以返回连接对象

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {


    private static JedisPool jedisPool;


    static {

        // 获取配置对象
        Properties pro = new Properties();
        InputStream rs = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        try {
            pro.load(rs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取Jedis连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 给config对象传入配置
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        // 创建连接池对象，并且传入连接池配置对象
        jedisPool = new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));


    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
