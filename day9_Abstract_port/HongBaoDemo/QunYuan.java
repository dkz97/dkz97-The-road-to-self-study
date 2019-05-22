package day9_Abstract_port.HongBaoDemo;


import java.util.ArrayList;
import java.util.Random;

// 创建群员类
public class QunYuan extends UserDemo {

    public QunYuan() {

    }

    public QunYuan(String name,int remainMoney) {
        super(name, remainMoney);

    }

    /*收红包三要素
    1.返回值类型: 收红包就不用返回值了 void
    2.方法名称: shouHongBao
    3.参数列表: 收红包 ArrayList(Integer)
    */
    public void shouHongBao(ArrayList<Integer> list) {
        // 从多个红包中随机抽一个给自己
        // 从list集合中随机抽一个索引值
        Random random = new Random();
        int index = random.nextInt(list.size());
        // 获取红包
        int money = list.remove(index);
        // 获取用户本身的余额
        int leftmoney = super.getRemainMoney();
        // 把红包加进余额
        super.setRemainMoney(money + leftmoney);

        // 输出余额还剩多少
        super.show();
    }

}
