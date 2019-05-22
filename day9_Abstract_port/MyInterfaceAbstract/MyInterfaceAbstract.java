package day9_Abstract_port.MyInterfaceAbstract;


public class MyInterfaceAbstract extends FuInterfaceDemo {


    public static void main(String[] args) {
        FuInterfaceDemo interFace = new FuInterfaceDemo();
        interFace.show();
        interFace.defaultMethod();
        InterfaceDemo.staticMethod();
        System.out.println(InterfaceDemo.num);
    }



}
