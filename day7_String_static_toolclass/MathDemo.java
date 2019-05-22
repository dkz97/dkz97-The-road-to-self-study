package day7_String_static_toolclass;


// 练习Math
public class MathDemo {

    public static void main(String[] args) {
        System.out.println(Math.abs(-3));       //3
        System.out.println(Math.ceil(31.2));    //32.0
        System.out.println(Math.floor(31.2));   //31.0
        System.out.println(Math.round(31.6));   //32

        count();
    }

    // 计算-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个
    public static void count() {
        int count = 0;
        for (int i = (int) -10.8; i > -10.8 && i < 5.9; i++) {
            if (Math.abs(i) > 6 || Math.abs(i) < 2.1) {
                count += 1;
            }
        }
        System.out.println(count);
    }

}
