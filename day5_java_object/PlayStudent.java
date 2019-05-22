package day5_java_object;

//导入Student包
/*
1.导包
2.创建对象
3.调用方法和属性

*/
import day5_java_object.Student;
public class PlayStudent {
    public static void main(String[] args) {
        // 创建一个类对象
        Student stu = new Student();

        //使用类属性,和修改类属性
        stu.name = "赵丽颖";
        stu.age = 18;

        //使用类方法
        stu.sleep();

        // 使用传了类对象的方法
        method(stu);

        // 类对象作为返回值
        Student stu2 = method();
        System.out.println(stu2.name);
    }


    // 类也可以作为方法的参数进行传参，给的是地址值
    public static void method(Student param) {
        System.out.println(param.name);
    }

    // 类对象作为方法的返回值
    public static Student method() {
        Student stu2 = new Student();
        stu2.name = "迪丽热巴";
        return stu2;

    }
}
