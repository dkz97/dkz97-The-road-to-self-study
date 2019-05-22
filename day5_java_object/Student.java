package day5_java_object;


/*
定义一个学生类
定义一个类，就需要有属性和行为两个成分

学生类
属性(类的属性):
    姓名
    年龄
    性别
行为(能做什么):
    睡觉
    吃饭
    学习

在Java中
成员变量(属性) : 定义在类中，方法外面的
成员方法(行为) : 成员方法不用写static关键字

*/
public class Student {

    //定义属性
    String name;
    int age;
    private boolean male;

    // 定义方法
    public void sleep() {
        System.out.println("睡觉");
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public void study() {
        System.out.println("学习");
    }


    // 对male进行封装，boolean类型的取读取只能是is ,不能是get
    public void setMale(boolean b) {
        male = b;
    }
    public boolean isMale() {
        return male;
    }

}
