package Day25_Junit_Reflect_Note.ClassDemo01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class properties {

    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("Day25_Junit_Reflect_Note.ClassDemo01.PersonDemo01");
        Object o = aClass.newInstance();
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field num = aClass.getField("num");
        System.out.println(num.get(o));

        num.set(o,10);
        System.out.println(num.get(o));

        // 创建构造器，获取类对象,创造构造器的时候，传入的是参数的class类
        Constructor constructor = aClass.getConstructor(int.class,String.class,int.class,int.class);
        // 使用创建对象的时候也要顺便传入参数
        Object o1 = constructor.newInstance(1,"1",1,1);
        System.out.println(o1);

        // 使用方法
        Method show = aClass.getMethod("show");
        show.invoke(o1);

    }

}
