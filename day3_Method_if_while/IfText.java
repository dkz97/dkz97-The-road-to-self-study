package day3_Method_if_while;

public class IfText {
    public static void main(String[] args) {
        // 成绩问题
        int sorce = 40;
        if (sorce > 90) {
            System.out.println("成绩优秀");
        } else if (sorce > 80) {
            System.out.println("成绩好");
        } else if (sorce > 70) {
            System.out.println("成绩良");
        } else if ( sorce > 60) {
            System.out.println("成绩及格");
        } else {
            System.out.println("成绩不及格");
        }
        ifElse();
    }

    // if else和三元运算符
        // 求最大值
    public static void ifElse() {
        int a = 10;
        int b = 20;
        //先用if else
        if (a > b) {
            System.out.println("a");
        } else {
            System.out.println("b");
        }
        //再用三元运算符
        int c = a > b ? a : b;
        System.out.println(c);
    }
}
