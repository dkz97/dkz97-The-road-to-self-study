package dkz97.customBean.Bean;


import java.io.InputStream;
import java.util.Properties;

/**
 * 简单的解耦，设置方法，可以传入名称，调用参数，获取类
 */
public class BeanFactory {

    public static Object getBean(String beanName) throws Exception{

        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("Bean.properties");

        Properties pro = new Properties();
        pro.load(is);

        String name = pro.getProperty(beanName);

        return Class.forName(name).newInstance();

    }

}
