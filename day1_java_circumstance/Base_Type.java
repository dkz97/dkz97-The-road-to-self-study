package day1_java_circumstance;

/*
常量 : 在程序的运行期间，固定不变的量

常量的分类:
1.整数常量:数字类型的如, 1 2 3214  -321等
2.浮点数常量:就是小数类型的, 0.0 0.1 1.2 -32.0
3.字符常量:一个字符 用单引号 '1' '2' '单'
4.字符串常量:一串一字符 用双引号 "1dsa" "多个"
5.布尔常量:true 或者false
6.空常量:null,代表没有任何数据

*/

public class Base_Type {
    public static void main(String[] args){
        //整数常量
        System.out.println(123);
        System.out.println(-12);

        //浮点数常量
        System.out.println(12.3);
        System.out.println(-12.3);

        //字符常量
        System.out.println('单');
        //System.out.println('');       字符常量里面不可以为空
        //System.out.println('dsa');    字符常量只能有一个

        //字符串常量
        System.out.println("字符串");
        System.out.println("");     //两个引号里面可以为空
        System.out.println("123");

        //布尔常量
        System.out.println(false);
        System.out.println(true);

        //空常量
        //System.out.println(null);     空常量无法直接println()
    }
}
