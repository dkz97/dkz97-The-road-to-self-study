package day5_java_object;

import java.util.Arrays;

public class PrintArray {
    public static void main(String[] args) {
        // 用面向过程来打印数组格式
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.println(numbers[i] + "]");
            } else {
                System.out.print(numbers[i] + ",");
            }
        }
        System.out.println("=================");


        // 面向对象实现
        // 就是找人帮我做事，或者用其他类，库
        System.out.println(Arrays.toString(numbers));
    }
}
