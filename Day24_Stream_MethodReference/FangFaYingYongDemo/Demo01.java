package Day24_Stream_MethodReference.FangFaYingYongDemo;

public class Demo01 {

    public static void getprint(PrintlnDemo01 prt) {
        prt.printDemo("hello");
    }

    public static void main(String[] args) {
        PrintlnDemo02 prt = new PrintlnDemo02();

        /*
        * 1. 调用本类的方法getprint(传入的参数是函数式接口)
        * 2. 本类方法调用的是函数式接口的方法
        * 3. lambda,也相当于内部类的new 了一个新的函数式接口对象当参数传递进去，并且重写了方法printDemo
        * 4. prt::printlnDemo 相当于用prt对象调用了方法printlnDemo，然后把参数"hello"给方法printlnDemo()传递了参数，然后执行
        * printlnDemo方法里面的方法体*/
        getprint(prt::printlnDemo);

        getprint((a)->{
            prt.printlnDemo(a);
        });
    }

}
