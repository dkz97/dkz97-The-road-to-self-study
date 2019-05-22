package Day17_notify_wait.WaitNotify;

public class ProducerDemo01 implements Runnable {

    private BaoZiDemo01 baozi;

    public ProducerDemo01(BaoZiDemo01 baozi) {
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
                    System.out.println("还有包子，等生产者生产完弄完先");
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("包子已经没有了，制造包子");
                    baozi.flage = true;
                    baozi.notify(); // 叫醒消费者吃饭
                }
            }
        }
    }
}
