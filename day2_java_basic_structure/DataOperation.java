package day2_java_basic_structure;

/*
1. char/byte/short这三种类型都可以互相的进行数学运算，例如加法"+'
2. 数学运算的时候都会变成int类型
3. 使用的是二进制进行运算
*/
public class DataOperation {
    public static void main(String[] args){
        char zifu1 = '中';
        int result1 = zifu1 +1;
        System.out.println(result1); // 20014

        //值得注意的是，每次运算都会转换成int类型后再进行运算，所以需要转换成范围小的类型需要使用强制转换
    }
}
