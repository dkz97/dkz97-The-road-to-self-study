package Day22_IO.SerializableDemo;

import java.io.Serializable;

public class StudentDemo01 implements Serializable {

    private static final long serialVersionUID = 2032L;
    private String name;
    private int age;

    public StudentDemo01() {};

    public StudentDemo01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StudentDemo01=" + "name: " + getName() + " " + "age: " + getAge();
    }
}
