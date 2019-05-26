package Day25_Junit_Reflect_Note.ClassDemo01;

public class PersonDemo01 {

    private int age;
    private String name;
    public int num;
    public int result;
    protected int start;


    public void add(int a, int b) {
        System.out.println(a + b);
    }

    public  void show() {
        System.out.println("静态方法");
    }

    void show(String str) {
        System.out.println("并非静态方法" + str);
    }



    public PersonDemo01() {
    }

    public PersonDemo01(int age, String name, int num, int result) {
        this.age = age;
        this.name = name;
        this.num = num;
        this.result = result;
    }

    @Override
    public String toString() {
        return "PersonDemo01{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", result=" + result +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
