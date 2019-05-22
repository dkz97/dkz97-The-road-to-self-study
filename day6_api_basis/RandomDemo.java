package day6_api_basis;

import java.util.Random;
import java.util.Scanner;

public class RandomDemo {

    public static void main(String[] args) {
        randitNumber();
        numberGame();
    }

    // 根据int变量n的值，求随机数字，范围是[1,n]，可以取1也可以取n
    public static void randitNumber() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("输入n: ");
        int n = sc.nextInt();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(n) + 1;
            System.out.println(num);
        }
    }

    // 猜数字大小的小游戏
    public static void numberGame() {
        Random r = new Random();
        Scanner scr = new Scanner(System.in);
        int num = r.nextInt(101);
        while (true) {
            System.out.print("输入你猜的数字： ");
            int num2 = scr.nextInt();
            if (num2 > num) {
                System.out.println("猜大了，继续猜！");
            } else if (num2 < num) {
                System.out.println("猜小了，继续猜！");
            } else {
                System.out.println("猜对了，恭喜你！");
                break;
            }

        }
    }
}

