package dkz97.service.impl;

import dkz97.dao.CategoryDao;
import dkz97.dao.Impl.CategoryDaoImpl;
import dkz97.domain.Category;
import dkz97.service.CategoryService;
import dkz97.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {


    CategoryDao dao = new CategoryDaoImpl();
    /**
     * 查询所有导航栏的方法
     * 使用redisj进行缓存优化
     * @return
     */
    @Override
    public List<Category> findAll() {
        // 1.从redis中查询
        Jedis jedis = JedisUtil.getJedis();

        // 2.判断redis中查询是否为空,并且要把分数查询出来，这样才能设置cid tuple里面存储的是分数和存储的对象
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);

        List<Category> all = null;
        if (categorys == null || categorys.size() == 0) {
            //2.1 为空就从数据库查询，并且存入redis
            all = dao.findAll();
            // 获取的是list集合，存入到set集合中并且给予分数，从小到大排列，分数就是对象的id
            for (Category ca :all) {
                jedis.zadd("category",ca.getCid(),ca.getCname());
            }
        }
        else {
            //2.2 不为空则直接从redis中获取
            // 但是由于redis那个是set集合，需要先存储到list集合中
            all = new ArrayList<Category>();
            for (Tuple tuple:categorys) {
                // 因为categorys存入的都是导航栏的名称，所以可以遍历获取名称，然后创建新的Category对象，设置名称加入到列表中返回
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                // 设置好的对象后加入到列表中
                all.add(category);
            }
        }

        return all;

    }
}
