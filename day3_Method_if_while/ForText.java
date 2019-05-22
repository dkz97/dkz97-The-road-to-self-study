package day3_Method_if_while;

public class ForText<system> {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        hundredAdd();
        longHourAndMinute();
    }

    // for循环实现1+到100
    public static void hundredAdd() {
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result += i;
        }
        System.out.println(result);
    }

    
    // for循环嵌套实现小时分钟秒
    public static void longHourAndMinute() {
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                for (int second = 0 ; second < 60; second++)
                System.out.println("现在的时间是" + hour + "点" + minute + "分" + second + "秒");
            }
        }
    }
}
