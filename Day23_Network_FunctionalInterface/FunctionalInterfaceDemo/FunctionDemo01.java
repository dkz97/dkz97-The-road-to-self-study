package Day23_Network_FunctionalInterface.FunctionalInterfaceDemo;

/*
String str = "赵丽颖,20";
1. 将字符串截取数字年龄部分，得到字符串；
2. 将上一步的字符串转换成为int类型的数字；
3. 将上一步的int数字累加100，得到结果int数字。*/

import java.util.function.Function;

public class FunctionDemo01 {

    public static int convert(String str, Function<String,Integer> fun) {
        return fun.apply(str);
    }

    public static void main(String[] args) {
        String str = "赵丽颖,20";
        int num = convert(str,(s)->{
            return Integer.parseInt(s.split(",")[1]) + 100;
        });
        System.out.println(num);
    }
}
