package Day20_ThreadPool_Lambda.ThreadPoolDemo01;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo01 {

    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService exc =Executors.newFixedThreadPool(3);

        // 把Runnable的实现类传递进去
        exc.submit(new ThreadDemo01());

        // 使用lambda表达式创建线程
        exc.submit(()->{
            System.out.println(Thread.currentThread().getName() + "不知道行不行");
        });

        // 使用匿名内部类创建线程
        exc.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "第二个线程");
            }
        });

        // 使用lambda表达式创建线程，并且更加省略
        exc.submit(()-> System.out.println(Thread.currentThread().getName() + "超级省略模式"));


    }



}
