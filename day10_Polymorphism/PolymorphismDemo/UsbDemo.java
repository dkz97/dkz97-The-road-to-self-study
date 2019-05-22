package day10_Polymorphism.PolymorphismDemo;

import java.security.Key;

public class UsbDemo {

    public static void main(String[] args) {
        // 创建一台计算机
        Laptop laptop = new Laptop();
        // 开机
        laptop.laptopOn();

        // 电脑连接鼠标
        UsbInterface usb = new Mouse();
        laptop.useDevice(usb);


        KeyBoard keyBoard = new KeyBoard();  // 正常创建，没有多态，是一个实例类对象
        // 虽然要的参数是usb接口，但是传递进去的是实例类对象
        laptop.useDevice(keyBoard);


        // 关机
        laptop.laptopOff();
    }

}
