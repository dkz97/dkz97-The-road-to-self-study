package day5_java_object;

public class Person {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("我的名字是" + name + "年龄" + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int num) {
        if ( num > 0 ) {
            age = num;
        } else {
            System.out.println("输入数据错误");
        }
    }

    public int getAge() {
        return age;
    }
}
