package Day24_Stream_MethodReference.MethodReference;

public class ClassMethodDemo {

    public static void addDemo(ClassInterfeceDemo01 cifd) {
        cifd.add(10);
    }


    public static void main(String[] args) {
        // 使用lambda表达式
        addDemo((num)->{
            ObjectMethod.addStaticDemo(num);
        });

        // 使用类名的方法引用
            // 方法用类名可以调用，参数会自动传入到这个方法中
        addDemo(ObjectMethod::addStaticDemo);
    }


}
