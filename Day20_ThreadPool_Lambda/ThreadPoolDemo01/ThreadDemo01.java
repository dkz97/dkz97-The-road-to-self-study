package Day20_ThreadPool_Lambda.ThreadPoolDemo01;

public class ThreadDemo01 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "我是线程");
    }

}
