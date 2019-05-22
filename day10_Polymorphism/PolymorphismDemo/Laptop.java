package day10_Polymorphism.PolymorphismDemo;

public class Laptop {

    public void laptopOn() {
        System.out.println("笔记本电脑开机");
    }

    public void laptopOff() {
        System.out.println("笔记本电脑关机");
    }

    // 使用usb接口
    public void useDevice(UsbInterface usb) {
        // 打开设备
        usb.open();

        // 利用向下转型来访问子类特有方法
        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;
            mouse.type();
        }

        if (usb instanceof KeyBoard) {
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.type();
        }
        // 关闭设备
        usb.close();

    }

}
