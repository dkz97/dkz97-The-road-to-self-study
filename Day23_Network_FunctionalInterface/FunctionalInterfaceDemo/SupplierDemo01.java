package Day23_Network_FunctionalInterface.FunctionalInterfaceDemo;


import java.util.function.Supplier;

// 利用Supplier接口，通过Lambda表达式求出int数组中最大值
public class SupplierDemo01 {

    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,20,1,43,23,50};

        int max = getMax(()->{
            int max1 = 0;
            for (int num : nums) {
                if (num > max1) {
                    max1 = num;
                }
            }
            return max1;
        });
        System.out.println("最大值为: " + max);
    }
}
