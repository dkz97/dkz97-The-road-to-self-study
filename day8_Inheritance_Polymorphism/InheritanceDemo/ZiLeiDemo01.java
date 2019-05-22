package day8_Inheritance_Polymorphism.InheritanceDemo;

public class ZiLeiDemo01 extends FuLeidemo1{




    public ZiLeiDemo01() {
        super("指定父类的构造方法");
        System.out.println("子类的构造方法在后面");
    }


    @Override       //证明对父类的方法进行重写
    public void method() {
        super.method(); //用super.就算重写也可以进行用上一个父类的留下的
        System.out.println("这个是子类的方法，可以重写父类的");
        System.out.println("这个是子类的方法，可以重写父类的");
    }

    @Override
    public void phtone() {
        super.phtone();
        System.out.println("还可以看来电显示");
    }
}
