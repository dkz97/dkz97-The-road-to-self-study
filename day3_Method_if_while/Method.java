package day3_Method_if_while;

//方法练习题
public class Method {
    public static void main(String[] args) {
        number(2, 3);
        System.out.println(number(2, 2));
        System.out.println(result());
        helloWorld(10);
    }

    // 定义一个方法，判断两个数字是否相同
    public static boolean number(int a, int b) {
        if (a == b) {
            System.out.println("这个数相同");
        } else {
            System.out.println("这两个数不同");
        }
        return a == b;
    }

    // 定义一个方法，求出1到100之间的和
    public static int result() {
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result += i;
        }
        return result;
    }

    // 打印制定次数的 hello world
    public static void helloWorld(int number) {
        for ( int i = 0; i < number; i++) {
            System.out.println("Hello World!");
        }
    }
}
