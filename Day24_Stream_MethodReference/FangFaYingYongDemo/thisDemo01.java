package Day24_Stream_MethodReference.FangFaYingYongDemo;

public class thisDemo01 {

    public static void show(PrintlnDemo01 p) {
        p.printDemo("hello");
    }

    public static void print(String str) {
        System.out.println(str.toUpperCase());
    }


    public static void main(String[] args) {
        show(System.out::println);
        show(thisDemo01::print);
    }

}
