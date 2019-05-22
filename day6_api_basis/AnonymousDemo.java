package day6_api_basis;
import java.util.Scanner;
// 匿名对象要用只能用一次
// 直接new 类名().属性/方法  就可以使用
// 可以作为方法的参数

public class AnonymousDemo {
    public static void main(String[] args) {
        anonymous(new Scanner(System.in));
        Scanner sc = anonymous();
        System.out.print("再次输入一个数字: ");
        sc.nextInt();
    }

    // 使用匿名函数进行传参
    public static void anonymous(Scanner sc) {
        System.out.print("输入一个数字: ");
        int num1 = sc.nextInt();
        System.out.println("输入的数字是: " + num1);
    }

    // 匿名函数也可以作为一个返回值
    public static Scanner anonymous() {
        return new Scanner(System.in);
    }
}
