package day13_InnerClass_Api;

import day13_InnerClass_Api.Demo1.MyInterfaceImpl;
import day13_InnerClass_Api.Demo1.MyInterfaceInner;

public class IneerClass {

    public static void main(String[] args) {
        IneerClassDemo ineerclass = new IneerClassDemo();
        ineerclass.outMethod();

        // 内部类的使用
        IneerClassDemo.Ineer ineer = new IneerClassDemo().new Ineer();
        ineer.ineerMethod11();

        // 使用接口
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.inner();

        // 也可以使用匿名内部类来直接重写接口，不需要重新创建一个类
        MyInterfaceInner impl1 = new MyInterfaceInner() {
            @Override
            public void inner() {
                System.out.println("匿名内部类的重写");
            }
        };
        impl1.inner();
    }


}
