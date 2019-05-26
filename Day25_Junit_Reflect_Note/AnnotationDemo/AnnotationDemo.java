package Day25_Junit_Reflect_Note.AnnotationDemo;

import java.lang.annotation.Annotation;

@MyAnnotation(printDemo = "10",myan = @MyAnnotation2,strs = {"1","2"})
public class AnnotationDemo {

    public static void main(String[] args) {
        Class<AnnotationDemo> annotationDemoClass = AnnotationDemo.class;
        Annotation[] annotations = annotationDemoClass.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
        MyAnnotation annotation = annotationDemoClass.getAnnotation(MyAnnotation.class);

        String s = annotation.printDemo();
        // 使用注解的对象.方法，相当于重写了方法，返回的是在注解定义的时候中传入的数据


    }


}
