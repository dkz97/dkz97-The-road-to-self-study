package dkz97.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileUpload {


    /**
     * 文件上传到别的服务器中
     */
    @RequestMapping("/uploadServer")
    public String testUploadServer(MultipartFile upload) throws Exception{

        // 设置需要上传到的服务器的位置以及目录
        String path = "http://localhost:8090/uploads/";

        // 根据文件解析器，获取文件的名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;

        // 创建sun公司包提供的Client对象
        Client client = Client.create();

        // resource 传入路径，指定上传文件的地址
        WebResource webResource = client.resource(path + filename);

        // 写入文件
        webResource.put(upload.getBytes());

        return "success";
    }




    /**
     * 文件上传的测试类(springMvc的)
     */
    @RequestMapping("/springmvcupload")
    public String testSpringMvcFileUpload(HttpServletRequest request, MultipartFile upload) throws Exception{

        // 获取一个文件夹的真实路径，然后在文件夹中创建文件,主要是配置，上传文件的位置
        // getRealPath，主要是获取网站的物理路径，就是系统的路径位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 创建一个File对象，传入路径，如果路径不存在的话，这个file是不会创建的
        File file = new File(path);
        // 判断文件对象是否存在，不存在的话就创建uploads这个目录
        if (!file.exists()){
            // file不存在，就可以创建文件夹
            file.mkdirs();
        }

        // 由于文件解析器，返回的MultipartFile都是文件项，所以就不用再判断，还能直接获取名字
        String filename = upload.getOriginalFilename(); // 获取文件的名称
        // 使用uuid，对文件名称进行唯一命名
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;

        // 将文件写入在本地
        upload.transferTo(new File(path,filename));

        return "success";
    }



    /**
     * 文件上传的测试类（传统）
     */
    @RequestMapping("/upload")
    public String testFileUpload(HttpServletRequest request) throws Exception{

        // 获取一个文件夹的真实路径，然后在文件夹中创建文件,主要是配置，上传文件的位置
        // getRealPath，主要是获取网站的物理路径，就是系统的路径位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 创建一个File对象，传入路径，如果路径不存在的话，这个file是不会创建的
        File file = new File(path);
        // 判断文件对象是否存在，不存在的话就创建uploads这个目录
        if (!file.exists()){
            // file不存在，就可以创建文件夹
            file.mkdirs();
        }

        // 解析request对象，获取文件，并且保存在内地
        // DiskFileItemFactory这个工厂类了就是将请求体中每一个项目封装成单独的东西，有文件类型的，有表单类型的
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // ServletFileUpload 就是将文件项和普通表单分开的，需要把工厂类加上
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 开始解析request，然后将每一项都打包在列表中
        List<FileItem> items = upload.parseRequest(request);
        // 然后遍历items，进行筛选，如果是文件项就保存在系统中
        for (FileItem item : items) {
            if (item.isFormField()) {
                // true就是普通表单项
            } else {
                //false 就是文件项
                String filename = item.getName(); // 获取文件的名称
                // 使用uuid，对文件名称进行唯一命名
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename = uuid + "_" + filename;
                item.write(new File(path,filename)); // 写入文件，名称为filename,目录就在前面的path中
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }

}
