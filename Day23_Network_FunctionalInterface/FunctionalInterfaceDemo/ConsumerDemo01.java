package Day23_Network_FunctionalInterface.FunctionalInterfaceDemo;

import java.util.function.Consumer;

public class ConsumerDemo01 {

    public static void printInfo(String[] args, Consumer<String[]> con) {
        con.accept(args);
    }


    public static void main(String[] args) {
        String[] array ={"迪士尼,公园", "漫威集团,漫画", "万达集团,地产"};
        printInfo(array, (String[] arra)-> {
            for (String str : arra) {
                String[] strs = str.split(",");
                System.out.println("姓名: " + strs[0] + " " + "性质: " + strs[1]);
            }
        });
    }

}
