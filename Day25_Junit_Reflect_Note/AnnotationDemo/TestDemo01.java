package Day25_Junit_Reflect_Note.AnnotationDemo;


@SuppressWarnings({"all"}) // 会把所有警告压下来
public class TestDemo01 implements TestInterfaceDemo01{


    @Override
    public void show() {
        System.out.println("Override注解是用来看程序是否继承自父类的方法重载");
    }

    @Deprecated
    public void show1() {
        // 过时的方法
    }

    public void show2() {
        show1();
    }


}
