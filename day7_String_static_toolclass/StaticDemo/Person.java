package day7_String_static_toolclass.StaticDemo;


// 创建一个含有静态方法和静态变量的person类
public class Person {

    private String name;
    private int age;
    static String classroom;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static {
        System.out.println("我是静态代码块");
    }
    public void show() {
        System.out.println("我不是静态方法");
    }

    public static void staticMethod() {
        System.out.println("我是一个静态方法");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
