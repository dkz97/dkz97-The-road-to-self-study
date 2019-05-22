package day3_Method_if_while;

public class WhileText {
    public static void main(String[] args) {
        int x = 0;
        while (x < 100) {
            System.out.println(x);
            x += 1;
        }
        hundredAdd();
        hundredAdd2();
    }

    // while循环实现1+100
    public static void hundredAdd() {
        int x = 0;
        int result = 0;
        while (x < 100) {
            x++;
            result += x;
        }
        System.out.println(result);
    }

    // do while循环实现1+100
    public static void hundredAdd2() {
        int x = 0;
        int result = 0;
        do {
            x++;
            result += x;
        } while (x < 100);
        System.out.println(result);
    }
}
