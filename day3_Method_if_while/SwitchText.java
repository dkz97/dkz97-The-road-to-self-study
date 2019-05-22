package day3_Method_if_while;

public class SwitchText {
    public static void main(String[] args){
        int num = 10;
        switch (num) {
            case 1:
                System.out.println("数字1");
                break;
            case 2:
                System.out.println("数字2");
                break;
            case 3:
                System.out.println("数字3");
                break;
            default:
                System.out.println("不是数字1，2，3");
                break;
        }
    }
}
