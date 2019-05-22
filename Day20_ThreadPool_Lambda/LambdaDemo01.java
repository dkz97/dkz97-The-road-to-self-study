package Day20_ThreadPool_Lambda;

public class LambdaDemo01 {

    public static void main(String[] args) {
        Cook cook = new Cook() {
            @Override
            public void makeFood() {
                System.out.println("回家吃饭");
            }
        };
        invokeCook(cook);


        // Lambda表达式
        invokeCook(()-> {
            System.out.println("回家吃饭");
        });
    }

    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }

    public interface Cook {
        void makeFood();
    }


}
