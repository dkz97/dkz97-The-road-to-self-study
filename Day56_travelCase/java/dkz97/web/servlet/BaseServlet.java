package dkz97.web.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


// 主要是通过一些逻辑来执行其他servlet中集合的方法的，用来分配方法的
public class BaseServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 由于是通过他的子类来调用的这个方法，所以我们可以先获取访问路径
        String uri = request.getRequestURI();  // url获取的还有http的前缀，但是uri没有，所以就要uri
        // url 是http://localhost:8080/xxxx
        // uri 就只是后面的xxx
        System.out.println(uri);

        // 然后根据路径，获取最后一个斜杠的元素(基本上调用最后一个路径元素和调用的方法切合)
        int i = uri.lastIndexOf("/");
        // 然后获取了最后一个元素出来了， 就可以使用substring，可以根据给的索引，找到字符串的子字符串
        String methodName = uri.substring(i + 1);

        // 因为是别的servlet调用BaseServlet的，所以this的对象就是别人servlet
        // 使用this，根据方法名称来封装方法,this转换成类对象，就可以获取当前类对象的方法
            // getDeclaredMethod(方法名称,后面就是形参的class类型)
        try {
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 然后就可以调用方法,invoke(方法对象,传入参数)
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
