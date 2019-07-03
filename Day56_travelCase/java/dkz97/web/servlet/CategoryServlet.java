package dkz97.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dkz97.domain.Category;
import dkz97.service.CategoryService;
import dkz97.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 主要是用于分类数据展示的servlet
 */

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    CategoryService category = new CategoryServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 设置响应编码
        response.setContentType("application/json;charset=utf-8");

        // 调用CategoryService的方法 查询所有的导航栏分类
        List<Category> all = category.findAll();

        // 封装成json对象返回给前端
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(response.getOutputStream(),all);


    }

}
