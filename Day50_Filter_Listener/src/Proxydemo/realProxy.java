package Proxydemo;

public class realProxy implements ProxyInterface {
    @Override
    public String buyFridge(int money) {
        System.out.println("商家花了"+money+"钱买了个冰箱");
        return "冰箱";
    }

    @Override
    public void show() {
        System.out.println("展示冰箱....");
    }
}
