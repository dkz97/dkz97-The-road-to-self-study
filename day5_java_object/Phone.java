package day5_java_object;

// 定义一个手机类
/*
手机属性:品牌、价格、颜色
行为:打电话，发短信
*/
public class Phone {

    String brand;
    String price;
    String colour;

    public void phone() {
        System.out.println("打电话");
    }

    public void message() {
        System.out.println("发短信");
    }
}
