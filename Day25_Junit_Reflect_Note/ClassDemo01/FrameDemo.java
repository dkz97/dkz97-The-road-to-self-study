package Day25_Junit_Reflect_Note.ClassDemo01;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class FrameDemo {

    public static void main(String[] args) throws Exception {
        /*  1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
			2. 在程序中加载读取配置文件
			3. 使用反射技术来加载类文件进内存
			4. 创建对象
			5. 执行方法
*/
        // 创建Properties 配置文件对象
        Properties pro = new Properties();
        // 主要是获取配置文件的流对象
        ClassLoader classLoader = FrameDemo.class.getClassLoader(); // 这个可以获得类加载器对象
        InputStream prois = classLoader.getResourceAsStream("pro.properties"); // 类加载器对象的方法可以获取加载器下面的各种文件，AsStream就是变成字节流对象
        // 可以用load来加载，传入流对象
        pro.load(prois);
        System.out.println(pro);

        // 获取配置文件的路径
        String methodName = pro.getProperty("methodName");
        String className = pro.getProperty("className");

        // 反射技术，加载该类进内存
        Class aClass = Class.forName(className);
        // 创建对象
        Object o = aClass.newInstance();

        // 创建方法
        Method method = aClass.getMethod(methodName);
        // 执行方法
        method.setAccessible(true);
        method.invoke(o);
    }

}
