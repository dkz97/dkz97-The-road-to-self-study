package day5_java_object;

public class PrivateText {
    /*
    定义一个PrivateText lei的类，然后使用Private来对年龄进行封装，不能是负数
    这个类用来测试
     */
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(18);
        person.show();
    }

}
