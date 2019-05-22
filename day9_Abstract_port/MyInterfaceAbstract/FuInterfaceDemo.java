package day9_Abstract_port.MyInterfaceAbstract;

public class FuInterfaceDemo implements InterfaceDemo {

    @Override
    public void show() {
        System.out.println("继承了接口Demo，重写方法");
    }

    @Override
    public void show1() {
        System.out.println("一样");
    }



}
