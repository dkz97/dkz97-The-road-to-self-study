package day10_Polymorphism;

public class MultiDemo {

    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.methodFu();

        Fu zi1 = new Zi();
        // zi1.methodZi  使用了多态的，左父右子创建的对象不可以访问子类的方法
        // 成员方法:编译看左，运行看右边
        zi1.method();    // 访问的是公共的方法，会先执行子类的方法
        System.out.println(zi1.num); // 对于变量来说，会访问的是父类的变量

        // 向下转型
        Zi zhenZi = (Zi) zi1;
        zhenZi.methodZi();
    }

}
