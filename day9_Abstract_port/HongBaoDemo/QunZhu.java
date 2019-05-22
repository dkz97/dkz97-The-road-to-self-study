package day9_Abstract_port.HongBaoDemo;


import java.util.ArrayList;

// 继承群主类
public class QunZhu extends UserDemo {

    public QunZhu() {

    }

    public QunZhu(String name, int remainMoney) {
        super(name,remainMoney); //使用父类的全参构造方法
    }


    /*三要素
    1.返回值类型: ArrayList<Integer>
    2.参数列表: 1.总共发多少钱 int totalMoney  2.分成多少份  int count
    3.方法名称: faHongBao
    */
    public ArrayList<Integer> faHongBao(int totalMoeny, int count) {
        // 要一个集合，存储分完红包份额的钱
        ArrayList<Integer> list = new ArrayList<>();

        // 看一下余额剩余多少钱，当余额不足的时候不能发红包
        int leftMoeny = super.getRemainMoney();
        if (leftMoeny < totalMoeny) {
            System.out.println("您的余额不足");
            return list;
        }

        // 发成功的时候就扣余额里面的钱
        super.setRemainMoney(leftMoeny - totalMoeny);

        // 把发的钱平均分到红包中，如果有余数则分到最后一个
        int money = totalMoeny / count;
        int lastmoeny = totalMoeny % count;

        for (int i = 0; i < count - 1; i++) {
            list.add(money); // 装到红包列表里面去
        }

        list.add(lastmoeny + money); //把有余数的钱放在最后一个红包里面

        return list;
    }
}
