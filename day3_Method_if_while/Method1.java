package day3_Method_if_while;

// 方法重载练习题
public class Method1 {
    public static void main(String[] args) {
        System.out.println(sameType((short) 10,(short) 20));
        System.out.println(sameType(10L,20L));
        System.out.println(sameType((byte) 10, (byte) 10));
        System.out.println(sameType(10,10));
    }

    // 比较两个数据是否相同，分别是byte、short、int、long类型

    public static boolean sameType(byte a, byte b) {
        System.out.println("byte");
        return a == b;
    }

    public static boolean sameType(short a, short b) {
        System.out.println("short");
        return a == b;
    }

    public static boolean sameType(int a ,int b) {
        System.out.println("int");
        return a == b;
    }

    public static boolean sameType(long a, long b) {
        System.out.println("long");
        return a == b;
    }
}
