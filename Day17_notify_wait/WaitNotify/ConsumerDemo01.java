package Day17_notify_wait.WaitNotify;

public class ConsumerDemo01 implements Runnable{

    private BaoZiDemo01 baozi;

    public ConsumerDemo01(BaoZiDemo01 baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        synchronized (baozi) {
            while (true) {
                if (baozi.flage) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("有包子，可以吃包子");
                    baozi.flage = false;
                    baozi.notify(); // 叫醒生产者生产包子
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("没有包子，等生产包子");
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
