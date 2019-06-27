package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.FindProvinceimpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import service.ProvinceService;
import utils.JedisPoolUtils;

import java.util.List;

public class ProvinceServiceimpl implements ProvinceService {


    @Override
    public List<Province> findAll() {
        FindProvinceimpl findProvinceimpl = new FindProvinceimpl();
        List<Province> all = findProvinceimpl.findAll();

        return all;
    }

    @Override
    public String findAllJson() throws JsonProcessingException {
        // 1.先从redis中查询数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String province = jedis.get("province");

        //判断province是否为null
        if (province == null || province.length() == 0) {
            // 没有数据的话就是不存在，不存在的话就查询数据库
            FindProvinceimpl findProvinceimpl = new FindProvinceimpl();
            List<Province> all = findProvinceimpl.findAll();

            System.out.println("redis没有数据..，第一次添加。。。");
            // 查询数据库后变成json对象
            ObjectMapper mapper = new ObjectMapper();
            String provinces = mapper.writeValueAsString(all);

            // 并且添加到redis中，以后就可以直接在缓存中使用
            jedis.set("province",provinces);
            jedis.close(); //归还链接

            // 返回json
            return provinces;
        } else {
            // 如果redis中有数据，直接返回出去
            System.out.println("redis有数据，直接返回....");
            return province;
        }
    }
}
