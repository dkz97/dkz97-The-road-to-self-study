package day9_Abstract_port.HongBaoDemo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HongBaoDemo {

    public static void main(String[] args) {
        QunZhu qz = new QunZhu("群主",52);
        QunYuan qy1 = new QunYuan("成员A", 0);
        QunYuan qy4 = new QunYuan("成员D", 0);
        QunYuan qy3 = new QunYuan("成员C", 0);
        QunYuan qy2 = new QunYuan("成员B", 0);
        ArrayList<Integer> money = qz.faHongBao(30,4);
        qy1.shouHongBao(money);
        qy2.shouHongBao(money);
        qy3.shouHongBao(money);
        qy4.shouHongBao(money);


    }

}
