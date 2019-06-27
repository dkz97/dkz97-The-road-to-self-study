package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.FindProvinceimpl;
import domain.Province;
import service.impl.ProvinceServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/caseDemoServlet")
public class CaseDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        /*
        // 使用ProvinceServiceimpl来查找所有省份
        ProvinceServiceimpl proimpl = new ProvinceServiceimpl();
        List<Province> provinces = proimpl.findAll();

        // 将列表转化为json对象的字符串形式,再并且响应给浏览器
        ObjectMapper mapper = new ObjectMapper();
        String province = mapper.writeValueAsString(provinces);
*/

        // 使用redis的缓存获取数据
        ProvinceServiceimpl provinceServiceimpl = new ProvinceServiceimpl();
        String allJson = provinceServiceimpl.findAllJson();

        response.getWriter().write(allJson);

    }
}
