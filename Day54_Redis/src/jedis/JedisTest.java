package jedis;


import org.junit.Test;
import redis.clients.jedis.Jedis;
import utils.JedisPoolUtils;

import java.util.Set;

// 用来演示jedis的测试类
public class JedisTest {

    // 获取jedis对象
    Jedis jedis = new Jedis("127.0.0.1",6379);

    @Test
    public void testString() {
        //操作jedis对象
        jedis.set("username","zhangsan");
        jedis.set("password","123456");

        String username = jedis.get("username");
        System.out.println(username);

        // 关闭jedis对象
        jedis.close();
    }


    @Test
    public void testHash() {

        jedis.hset("name","zhangsan","123456");
        jedis.hset("name","lisi","123");

        System.out.println(jedis.hgetAll("name"));

        System.out.println(jedis.hget("name","zhangsan"));


        jedis.close();
    }


    @Test
    public void testList() {

        jedis.lpush("number","1","2","3");
        jedis.rpush("number","1","2","3");

        System.out.println(jedis.lrange("number",0,-1));

        System.out.println(jedis.lpop("number"));
        System.out.println(jedis.rpop("number"));
        jedis.close();

    }


    @Test
    public void testSet() {

        jedis.sadd("id","1","2","3","4");

        Set<String> id = jedis.smembers("id");
        System.out.println(id);

        jedis.srem("id","2");
        jedis.close();
    }

    @Test
    public void testJedisPool(){

        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("zhangsan","123456");

        jedis.close();
    }


    @Test
    public void testSortedSet() {

        jedis.zadd("bd",50,"php");
        jedis.zadd("bd",80,"java");
        jedis.zadd("bd",100,"python");

        Set<String> id = jedis.zrange("bd", 0, -1);
        System.out.println(id);

        jedis.close();

    }

}
