package Day20_ThreadPool_Lambda.CalculatorDemo01;


// 用来验证Lambda表达式的省略规则的
public class sumDemo02 {

    public static void main(String[] args) {
        sum(5,a->{
            System.out.println("结果是: " + a);
            return a;
        });
    }

    public static void sum(int a, sumDemo01 sum) {
        sum.add(a);
    }

}
