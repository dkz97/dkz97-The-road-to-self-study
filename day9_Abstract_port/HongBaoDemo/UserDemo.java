package day9_Abstract_port.HongBaoDemo;


// 定义一个用户的父类，就可以创建子类群员和群主
public class UserDemo {

    private String name;
    private int remainMoney;

    public UserDemo() {

    }

    public UserDemo(String name, int remainMoney) {
        this.name = name;
        this.remainMoney = remainMoney;
    }

    public void show() {
        System.out.println("我叫: " + name + "我还剩下多少钱: " + remainMoney);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(int remainMoney) {
        this.remainMoney = remainMoney;
    }
}
