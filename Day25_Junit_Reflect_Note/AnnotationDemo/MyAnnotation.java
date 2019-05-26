package Day25_Junit_Reflect_Note.AnnotationDemo;


// 自定义一个注解

import java.lang.annotation.*;
@Inherited // 子类继承父类的时候，子类会把注解继承下去
@Documented // 写上就证明，当类变成doc文件的时候，注解也会被写上去
@Retention(RetentionPolicy.RUNTIME) // 能够存活的被保留的阶段
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD}) // 能够作用的位置
public @interface MyAnnotation {

    String printDemo();

    String[] strs();

    MyAnnotation2 myan();

    String str() default "10";
}
