package dkz97.mybatis.sqlsession.proxy;

import dkz97.mybatis.Mapper.Mapper;
import dkz97.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    // map的key为全类名+方法名，
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String,Mapper> mappers,Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }
    /**
     * 对方法进行增强，就是调用select list方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名称
        String methodName = method.getName();
        // 2.获取调用的全类名
        String namespace = method.getDeclaringClass().getName();
        // 3. 组合全类名和方法，可以获取mapper的key
        String key = namespace + "." + methodName;
        // 4.判断value是否存在，不存在则抛出异常
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            // 抛出一个运行期异常
            throw new IllegalAccessException("传入的参数有误");
        }
        // 6.调用工具类 查询所有



        return new Executor().selectList(mapper,conn);
    }
}
