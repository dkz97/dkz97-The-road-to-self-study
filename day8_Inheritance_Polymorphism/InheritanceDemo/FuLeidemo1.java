package day8_Inheritance_Polymorphism.InheritanceDemo;

public class FuLeidemo1 {

    private int num = 1;

    public FuLeidemo1() {
        System.out.println("子类会自动创建父类的构造方法，并且在前面");
    }

    public FuLeidemo1(int num) {
        this.num = num;
    }

    public FuLeidemo1(String str) {
        System.out.println(str);
        System.out.println("子类还可以自己设定创建父类的构造方法");
    }

    public  void method() {
        System.out.println("父类的方法可以，等待子类重写");
    }


    public void phtone() {
        System.out.println("可以发信息");
        System.out.println("可以打电话");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
