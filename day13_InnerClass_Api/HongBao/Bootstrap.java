package day13_InnerClass_Api.HongBao;

/*
场景: 红包发出去后所有人都可以抢，可以平均，可以手气红包，除不尽多出来的由最后一个红包群主拿着
* 1.设置程序的标题，通过构造方法字符串参数
* 2.设置群主名称
* 3.设置分发是平均还是随机


*1.普通红包(平均): totalMoney / totalCount, 余数在最后一个
*2.随机红包: 最少1分钱，最多不能超过平均数的2倍
 */


public class Bootstrap {


    public static void main(String[] args) {
        Myred red = new Myred("张家浚的红包");
        // 设置群主名称
        red.setOwnerName("张家浚");

        // 普通红包
        NormalMode normal = new NormalMode();
        //red.setOpenWay(normal);

        // 随机红包
        RandomMode random = new RandomMode();
        red.setOpenWay(random);
    }

}
