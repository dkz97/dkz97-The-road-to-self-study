package day4_Array;

public class ArrayText {
    public static void main(String[] args) {
        //动态数组创建
        int[] numbers1 = new int[6]; //创建了一个容量为6，名字为numbers的整数类型数组
        //静态创建
        String[] str = new String[] {"123", "1234", "12345"};
        array();
        max();
        reversal();
        int[] array = {1,2,3,4,2,3,4};
        array(array);
    }

    // 数组的遍历
    public static void array() {
        // 数组的静态创建
        int[] numbers1 = {1, 22, 3, 4, 5, 6,};
        // 数组.length 可以返回数组的长度
        for (int i = 0; i < numbers1.length; i++) {
            System.out.println(numbers1[i]);
        }
    }

    // 求出数组的最大值
    public static void max() {
        int[] numbers = new int[] {1,213,42142,2,321,42152132,52132,42121,521};
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }
        System.out.println(result);
    }

    // 将数组元素反转，不可创建新列表
    public static void reversal() {
        int[] numbers = {1, 2, 4, 6, 3, 2, 6, 2, 234, 42};
        for (int left = 0,right = numbers.length - 1; right > left; left++, right-- ) {
            int result = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = result;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    // 数组的传参和数组的返回值
    public static int[] array(int[] arg) {
        System.out.println(arg[0]);
        System.out.println(arg[1]);
        int result1 = arg[0] + arg[1];
        int result2 = arg[1] + arg[2];
        int[] result = {result1, result2};
        return result;  // 数组作为返回值和传入值，都是内存地址
    }
}
