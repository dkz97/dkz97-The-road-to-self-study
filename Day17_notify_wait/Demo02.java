package Day17_notify_wait;

public class Demo02 {

    public static void main(String[] args) {
        Demo02 obj = new Demo02();
        Thread thread1 = new Thread(new Thread1(obj));
        Thread thread2 = new Thread(new Thread2(obj));
        Thread thread3 = new Thread(new Thread2(obj));
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();

    }

    public static class Thread1 implements Runnable {

        private Demo02 obj;
        public Thread1(Demo02 obj) {
            this.obj = obj;
        }
        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "沉睡中");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "醒了");
                }
            }
        }
    }

    public static class Thread2 implements Runnable {
        private Demo02 obj;

        public Thread2(Demo02 obj) {
            this.obj = obj;
        }
        @Override
        public void run() {
            synchronized(obj) {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    obj.notify();
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                }
            }
        }
    }
}
