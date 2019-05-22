package day7_String_static_toolclass;

import java.util.Arrays;
import java.util.Scanner;

// 把随机字符串中的所有字符升序排列，倒序打印
public class ArraysDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入一串字符串: ");
        String str = sc.next();
        char[] strs = str.toCharArray();    // 字符串变成字符数组

        Arrays.sort(strs);  // 用Arrays.sort() 对数组进行排序
        System.out.println(Arrays.toString(strs));

        for (int i = strs.length - 1; i >= 0; i--) {
            System.out.println(strs[i]);
        }
    }

}
