package day10_Polymorphism.PolymorphismDemo;

public class KeyBoard implements UsbInterface{

    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }

    public void type() {
        System.out.println("点击键盘");
    }
}
