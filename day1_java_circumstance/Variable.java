package day1_java_circumstance;

public class Variable {
    public static void main(String[] args){
        //变量的创建
        //数据类型 变量名称
        int num1;
        num1 = 12;
        System.out.println(num1);
        num1 = 20;  //可以直接进行修改
        System.out.println(num1);

        char zifu='中';
        System.out.println(zifu);

        boolean var=true;
        System.out.println(var);

        //变量之间也可以互相赋值
        char zifu2 = zifu;
        System.out.println(zifu2);

    }
}
