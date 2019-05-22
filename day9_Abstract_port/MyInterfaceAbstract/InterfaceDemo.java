package day9_Abstract_port.MyInterfaceAbstract;

public interface InterfaceDemo {
    // 定义接口变量，但是此变量是不可改变
    public static final int num = 10;


    // 在接口中定义两个抽象方法
    public abstract void show();
    public abstract void show1();

    // 定义默认方法
    public default void defaultMethod() {
        System.out.println("定义了默认方法");
        privateMethod();  // 使用普通私有方法
    }

    // 定义静态方法
    public static void staticMethod() {
        System.out.println("定义了静态方法");
        methodPrivate();    // 使用静态私有方法
    }

    // 定义普通私有方法
    private void privateMethod() {
        System.out.println("普通私有方法");
    }

    // 定义静态私有方法
    private static void methodPrivate() {
        System.out.println("静态私有方法");
    }
}
