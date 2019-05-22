package day7_String_static_toolclass.StaticDemo;


// 使用类名称来执行Static关键字的
public class StaticDemo {

    public static void main(String[] args) {
        Person person = new Person("过境",18);
        Person.classroom = "北京1010";    //使用类名称设置
        System.out.println(Person.classroom);
        Person.staticMethod();


    }

}
