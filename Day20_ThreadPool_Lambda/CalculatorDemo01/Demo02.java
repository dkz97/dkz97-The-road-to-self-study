package Day20_ThreadPool_Lambda.CalculatorDemo01;

public class Demo02 {

    public static void main(String[] args) {
        add(10, 20, new CalculatorIterface01() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        add(10,20, (int a, int b)-> {
            return a + b;
        });

        add(120,130, (a, b)->a + b);

        // 使用lambda实现多线程
        new Thread(()-> System.out.println("实现多线程")).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("lambda表达式主要是省略匿名内部类");
            }
        }).start();
    }

    public static void add(int a ,int b, CalculatorIterface01 calc) {
        int result = calc.calc(a,b);
        System.out.println("结果是: " + result);
    }

}
