package Day24_Stream_MethodReference.MethodReference;

public class ObjectNameMethod {

    public static void printDemo01(ObjectInterfectDemo01 oifd) {
        oifd.addDemo01("hello");
    }

    public static void main(String[] args) {
        // 使用lambda表达式来对方法进行
        printDemo01((str)->{
            ObjectMethod om = new ObjectMethod();
            om.printDemo(str);
        });

        ObjectMethod om = new ObjectMethod();
        // 使用方法引用来进行，对象::方法
        printDemo01(om::printDemo);
    }

}
