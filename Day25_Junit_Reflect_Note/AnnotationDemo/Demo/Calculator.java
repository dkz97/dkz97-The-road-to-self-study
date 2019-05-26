package Day25_Junit_Reflect_Note.AnnotationDemo.Demo;

import org.junit.Test;

// 定义的计算机类
public class Calculator {

    @Check
    public void add() {
        System.out.println("1 + 0 =" +(1 + 0));
    }

    public void sub() {
        System.out.println("1 - 0 =" +(1 - 0));
    }

    public void mul() {
        System.out.println("1 * 0 =" +(1 * 0));
    }
    @Check
    public void div() {
        System.out.println("1 / 0 =" +(1 / 0));
    }

    public void show() {
        System.out.println("永无Bug...");
    }



}
