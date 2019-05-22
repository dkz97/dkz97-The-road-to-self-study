package day6_api_basis;

/*导入Scanner包输入两个数字相加*/
import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        add();
        max();
    }



    // 键盘输入两个数字求和
    public static void add() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数字: ");
        int num1 = sc.nextInt();
        System.out.print("请输入第二个数字: ");
        int num2 = sc.nextInt();
        int result = num1 + num2;
        System.out.println("数字相加为: " + result);
    }

    // 键盘输入三个数字求最大值
    public static void max() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数字: ");
        int num1 = sc.nextInt();
        System.out.print("请输入第二个数字: ");
        int num2 = sc.nextInt();
        System.out.print("请输入第三个数字: ");
        int num3 = sc.nextInt();
        // 等到三位数的最大值
        int max = num1 > num2 ? num1:num2;
        int max2 = max > num3 ? max:num3;
        System.out.println("最大的数为: " + max2);
    }

}
