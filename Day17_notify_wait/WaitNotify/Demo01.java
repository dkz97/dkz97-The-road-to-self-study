package Day17_notify_wait.WaitNotify;

public class Demo01 {

    public static void main(String[] args) {
        BaoZiDemo01 baozi = new BaoZiDemo01();
        Thread producer = new Thread(new ProducerDemo01(baozi));
        Thread consumer = new Thread(new ConsumerDemo01(baozi));
        consumer.start();
        producer.start();


    }

}
