package day13_InnerClass_Api;

public class IneerClassDemo {

    public class Ineer {

        public void ineerMethod() {
            System.out.println("我叫: " + name);
            System.out.println("我是内部类的方法");
            outMethod();
        }

        public void ineerMethod11() {
            System.out.println("我是内部类方法");
        }

    }

    // 定义一个局部内部类
    public void innerClass() {
        class inner11 {
            public void methodinner() {
                System.out.println("我是局部内部类");
            }
        }
    }

    //定义一个外部类的变量
    private String name;

    // 定义一个外部类的方法
    public void outMethod() {
        System.out.println("这是外部类的方法");

        // 通过外部类方法创建内部类的对象然后可以间接使用内部类
        Ineer ineer = new Ineer();
        ineer.ineerMethod11();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
