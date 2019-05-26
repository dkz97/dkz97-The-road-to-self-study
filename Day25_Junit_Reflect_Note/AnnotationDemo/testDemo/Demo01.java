package Day25_Junit_Reflect_Note.AnnotationDemo.testDemo;


// 利用注解来实现文档和小型框架的交互，不要修改代码就可以使用到类中的方法


import java.lang.reflect.Method;

@MyAnnotation01(className = "Day25_Junit_Reflect_Note.AnnotationDemo.testDemo.Show2", methodName = "show")
public class Demo01 {

    public static void main(String[] args) throws Exception{
        // 获取Class类对象
        Class<Demo01> demo01Class = Demo01.class;
        // 通过类对象获取注解对象,传入的是注解的Class对象
        MyAnnotation01 myan = demo01Class.getAnnotation(MyAnnotation01.class);
        // 通过注解的对象使用方法获取属性
        String className = myan.className();
        String methodName = myan.methodName();

        // 使用反射来进行类对象的创建和方法的使用
        // 获取show1类的class对象
        Class aClass = Class.forName(className);
        // 使用class对象直接创建空参数对象
        Object o = aClass.newInstance();
        // 使用方法
        Method method = aClass.getMethod(methodName);
        method.invoke(o);



    }

}
