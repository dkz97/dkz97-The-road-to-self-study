package day13_InnerClass_Api.Demo1;

public class MyInterfaceImpl implements MyInterfaceInner {
    @Override
    public void inner() {
        System.out.println("重写接口的方法");
    }
}
