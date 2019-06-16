package download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class downloaddemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");

        // 使用字节数流入加载文件进内存
        // 获取两个文件的真实路径,首先获取context对象
        ServletContext servletContext = this.getServletContext();
        String realpath = servletContext.getRealPath("/img/" + filename);

        // 字节输入流关联
        FileInputStream fis = new FileInputStream(realpath);

        // 设置响应的mime类型
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type",mimeType);
        // 设置响应头以附件的形式打开
        resp.setHeader("content-disposition","attachment;filename="+filename);

        // 输入流的数据写出到输出流中
        ServletOutputStream os = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes,0,len);
            System.out.println(bytes);
        }

        fis.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
