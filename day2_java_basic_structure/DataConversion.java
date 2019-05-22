package day2_java_basic_structure;

public class DataConversion {
    public static void main(String[] args){
        int num1 = 10;
        System.out.println(num1);

        // 自动转换: 数据范围小的自动转换到自动范围大的数据类型
        float num2 = 10;    // 10.0
        System.out.println(num2);

        double num3 = 10L;
        System.out.println(num3);

        // 强制类型转换: 当需要从大数据范围转换到小数据范围的时候使用强制类型转换
        // 基本格式: 范围小的数据类型 变量名称 = (范围小的数据类型) 范围大的数据值
        int num4 = (int) 100L;
        System.out.println(num4);

        long num5 = (long) 50.0;
        System.out.println(num5);

        //强制类型转换不建议使用，因为会发生数据溢出和精度损失
        int num6 = (int) 6000000000L;   //右边的数值太大超出了整数，导致数据溢出
        System.out.println(num6);

        int num7 = (int) 20.99F;
        System.out.println(num7);   //右边也是数据范围大，会直接取出小数导致精度损失，不是四舍五入
    }
}
