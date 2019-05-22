package day7_String_static_toolclass.StringDemo;

import java.util.Scanner;

// 键盘输入一个字符串，统计其中字符出现的次数
// 大写字母 小写字母 数字 其他
public class StringDeom2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入: ");
        String str = sc.next();

        // 定义4个计算的变量
        int capital = 0;
        int lowerCase = 0;
        int number = 0;
        int other = 0;

        // 需要对字符串一个一个进行检查，可以遍历也可以变成字符数组形式
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];  //当个字符
            // 利用ASCII表来进行统计
            if (ch >= 'A' && ch <= 'Z') {
                capital += 1;
            } else if (ch >= 'a' && ch <= 'z') {
                lowerCase += 1;
            } else if (ch >= '0' && ch <= '9') {
                number += 1;
            } else {
                other += 1;
            }
        }

        System.out.println("大写字母有: " + capital + "小写字母有: " + lowerCase + "数字有: " + number + "其他有: " + other);
    }

}
