package Day23_Network_FunctionalInterface.FunctionalInterfaceDemo;


@FunctionalInterface
public interface Demo01 {
    //public abstract void method();//无参数无返回值的的函数式接口

    // 有参数有返回值的接口
    public abstract int method(int i);
}
