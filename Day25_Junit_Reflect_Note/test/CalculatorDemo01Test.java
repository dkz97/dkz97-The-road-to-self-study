package Day25_Junit_Reflect_Note.test;


import Day25_Junit_Reflect_Note.CalculatorDemo01;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorDemo01Test {

    @Before
    public void starts() {
        System.out.println("测试开始");
    }

    @Test
    public void testAdd() {
        int num = CalculatorDemo01.add(10,20);
        System.out.println("测试中");
        Assert.assertEquals(30,num);
    }

    @Test
    public void testSubtraction() {
        int result = CalculatorDemo01.subtraction(10,20);
        System.out.println("测试中");
        Assert.assertEquals(-10,result);
    }

    @After
    public void end() {
        System.out.println("测试完成");
    }

}
