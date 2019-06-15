package HTTP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;


// 获取请求体的数据，则表单提交只能搞Post的
@WebServlet("/demo04")
public class request_body extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget.....");



        // 获得字符输入流
//        BufferedReader reader = req.getReader();
//        // 遍历读取数据
//        String line = null;
//        while((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }
//        System.out.println("------------------");

        //设置编码模式
        req.setCharacterEncoding("utf-8");
        // 通用方法获取参数
        String name = req.getParameter("username");
        System.out.println(name);
        System.out.println("------------------");

        String[] hobbys = req.getParameterValues("hobby");
        System.out.println(hobbys);
        System.out.println("------------------");

        // 获取所有参数名称
        Enumeration<String> names = req.getParameterNames();
        while(names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp){
        System.out.println("demo04.....");
        Object usename = req.getAttribute("usename");
        System.out.println(usename);
    }
}
