package Day25_Junit_Reflect_Note.ClassDemo01;


import Day25_Junit_Reflect_Note.CalculatorDemo01;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 获取Class类对象的方法
/*
1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
		* 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
2. 类名.class：通过类名的属性class获取
		* 多用于参数的传递
3. 对象.getClass()：getClass()方法在Object类中定义着。
		* 多用于对象的获取字节码的方式*/
public class ClassObjectDemo01 {

    public static void main(String[] args) throws Exception {
        // 创建Class对象
        Class personclass = Class.forName("Day25_Junit_Reflect_Note.ClassDemo01.PersonDemo01");
        System.out.println(personclass);

        Class class2 = PersonDemo01.class;
        System.out.println(class2);

        PersonDemo01 person = new PersonDemo01();
        Class class3 = person.getClass();
        System.out.println(class3);


        // 1.从Class对象中获取成员变量    Field getDeclaredField(String name) 带Declared就可以获取全部，不带的话就只能获取public的
        System.out.println("------获取一组成员变量并遍历------");
        Field[] fields = personclass.getFields();// 返回public修饰符成员变量的数组
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("-----获取成员变量的值并且设置-----");
        Field numField = personclass.getField("num");
        // 获取Class对象成员变量的值，但是需要传入原类的对象名称
        PersonDemo01 p = new PersonDemo01();
        System.out.println(numField.get(p));
        // 设置Class对象成员变量的值
        numField.set(p,10);
        System.out.println(numField.get(p));
        // setAccessible(true):暴力反射， 可以使用静态成员变量
        numField.setAccessible(true);


        // 2.从Class对象中获取成员方法    Method[] getDeclaredMethods() 加Declared就获取全部，不加就获取public的
        System.out.println("------获取一组成员方法并遍历-----");
        Method[] methods = personclass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("------获取一个成员方法-----");
        // 前面是方法名称，后面是传入的参数类型的Class对象
        Method method = personclass.getMethod("add",int.class,int.class);
        // 执行方法就对象.invoke(类对象,方法参数)
        method.invoke(p,1,2);
        Method method1 = personclass.getDeclaredMethod("show");
        method1.setAccessible(true);
        method1.invoke(p);
        System.out.println(method1.getName());


        // 3.从Class对象中获取构造方法
        System.out.println("--------获取一组构造方法-------");
        Constructor[] constructors = personclass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        // 获取空参数构造方法
        Constructor constructor = personclass.getConstructor();
        System.out.println(constructor.getName());
        // Class类对象getConstructor() 可以获取构造器，传入的参数是class对象
        // newInstance()    传入的是参数，可以构造出类对象
        // 空参数的话可以直接用Class对象.newInstance() 来创建空的类对象
        Constructor constructor1 = personclass.getConstructor(int.class, String.class, int.class, int.class);
        Object o = constructor1.newInstance(1,"1",3,4);
        System.out.println(o);

    }


}
