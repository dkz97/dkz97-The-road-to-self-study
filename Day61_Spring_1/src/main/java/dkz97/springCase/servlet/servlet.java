package dkz97.springCase.servlet;

import dkz97.springCase.service.UserService;
import dkz97.springCase.service.impl.ServiceDemo;
import dkz97.springCase.service.impl.ServiceDemo02;
import dkz97.springCase.service.impl.ServiceDemo03;
import dkz97.springCase.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;

public class servlet {





    /**
     * 模仿三层架构的web层
     * 使用的是默认的构造方法 创建方式
     */
    @Test
    public void testDefault() {

        // 使用Spring的方法来进行映射

        // 1. 获取核心的容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据id获取bean对象
        UserService userService = ac.getBean("UserService",UserService.class);
        // 3. 使用bean对象
        userService.saveUser();

    }

    /**
     * 使用的是自定义一个工厂对象，然后从工厂对象的方法中获取service对象
     */
    @Test
    public void testFactory() {
        // 1.获取容器的核心对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据id获取bean对象
        UserService user = ac.getBean("getService", UserService.class);
        // 3.使用对象的方法
        user.saveUser();
    }

    /**
     * 使用自定义工厂类中的 静态方法 获取对象
     */
    @Test
    public void testStaticFacotry() {
        // 1.创建IOC核心对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据id获取对象
        UserServiceImpl user = ac.getBean("getServiceStatic", UserServiceImpl.class);
        // 3.调用方法
        user.saveUser();
    }

    /**
     * 测试构造函数注入的方法
     */
    @Test
    public void testConstructor() {
        // 1.创建核心ioc容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据id获取对象
        ServiceDemo serviceDemo = ac.getBean("ServiceDemo",ServiceDemo.class);
        // 3.打印
        System.out.println(serviceDemo.toString());
    }

    /**
     * 测试set方法注入数据
     */
    @Test
    public void testSet() {
        //1.创建核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获取对象
        ServiceDemo02 serviceDemo02 = ac.getBean("ServiceDemo02",ServiceDemo02.class);
        // 3.打印
        System.out.println(serviceDemo02.toString());
    }

    /**
     * 测试复杂类型/数组类型的数据注入
     */
    @Test
    public void testListAndSet() {
        //1.创建核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获取对象
        ServiceDemo03 serviceDemo03 = ac.getBean("ServiceDemo03",ServiceDemo03.class);
        // 3.打印
        System.out.println(Arrays.toString(serviceDemo03.getStrings()));
        System.out.println(serviceDemo03.toString());
    }
}
