package day10_Polymorphism.PolymorphismDemo;

public class Mouse implements UsbInterface {

    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }

    public void type() {
        System.out.println("点击鼠标");
    }

}
