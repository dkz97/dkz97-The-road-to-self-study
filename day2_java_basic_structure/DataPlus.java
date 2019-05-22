package day2_java_basic_structure;
/*
加法"+"的三种用法
1.数值相加就直接加就是了
2.字符的加法的话就先变成int再进行相加
3.字符串加法的话就是连接
字符串不管与什么数据类型进行相加，最终出来的都是字符串
*/
public class DataPlus {
    public static void main(String[] args){
        String str1 = "java";
        System.out.println(str1 + 1);

        String str2 = "Hello World";
        System.out.println(str1 + str2);
    }
}
