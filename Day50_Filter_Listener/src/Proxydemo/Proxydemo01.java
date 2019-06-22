package Proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxydemo01 {

    public static void main(String[] agrs) {

        // 先创建真实对象
        realProxy realProxy = new realProxy();

        // 使用newProxyInstance方法来获取proxy对象,动态代理增强realProxy对象
        /*
         *   传入的参数为，
         *      真实对象的类加载器 真实对象.getClass().getClassloader()
         *      真实对象的接口数组 真实对象.getClass().getInterfaces()
         *      还有新建一个处理器 new InvocationHandler()
         *   在里面的invoke可以进行方法的操作
         *  获取代理对象之后使用强转接口的方法
         * */
        ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(realProxy.getClass().getClassLoader(), realProxy.getClass().getInterfaces(), new InvocationHandler() {

            /*
            * 代理逻辑编写的方法，代理对象调用的所有的方法都会触发这个方法执行
            *   参数:
            *   1.proxy 代理对象
            *   2.method: 代理对象调用的方法被封装为的对象
            *   3.args: 代理对象调用的方法传入的参数被封装成为数组
            * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 使用method来执行方法
//                //传入真实参数
//                String string = (String) method.invoke(realProxy, args[0]);
//                return string;

                // 增强传入的参数
//                int money = (int)args[0] - 2000;
//                Object fridge = method.invoke(realProxy, money);
//                return fridge;

                // 增强返回值
//                Object fridge = method.invoke(realProxy, args[0]);
//                return fridge + "还有一个洗衣机";

                // 增强执行代码
                System.out.println("专车接过去。。。");
                Object invoke = method.invoke(realProxy, args[0]);
                System.out.println("专车送回来。。");
                return invoke;
            }
        });

        // 使用代理对象来调用方法，然后方法会封装成Method传入，args就是传入的数据，
        String s = proxy.buyFridge(5000);
        System.out.println(s);
    }
}
