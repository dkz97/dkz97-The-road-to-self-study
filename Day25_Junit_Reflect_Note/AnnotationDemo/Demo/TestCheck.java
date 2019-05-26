package Day25_Junit_Reflect_Note.AnnotationDemo.Demo;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

// 当主方法执行后，会自动执行被检测的所有方法(加了注册Check注解的方法)，判断是否有异常记录文件中
public class TestCheck {


    public static void main(String[] args) throws IOException {

        // 获取了计算机类的对象
        Calculator c = new Calculator();
        // 获取字节码文件对象
        Class aClass = c.getClass();
        // 获取所有方法
        Method[] methods = aClass.getMethods();

        // 记录异常
        int number = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("Bug.txt"));

        // 判断方法是否有Check注解，有的话就测试
        for (Method s : methods) {

            if (s.isAnnotationPresent(Check.class)) {
                // 测试之后，有异常就捕获
                try {
                    s.invoke(c);
                } catch (Exception e) {
                    // 捕获异常记录在文件中
                    number ++;
                    bw.write(s.getName() + " 方法出异常");
                    bw.newLine();
                    bw.write("异常的名称: " + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因: " + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------");
                }
            }
        }

        bw.write("本次一共出现" + number + "次异常");
        bw.flush();
        bw.close();
    }

}
