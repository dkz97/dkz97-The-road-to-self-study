package dkz97.web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import dkz97.domain.PageBean;
import dkz97.domain.Route;
import dkz97.domain.User;
import dkz97.service.FavoriteService;
import dkz97.service.RouteService;
import dkz97.service.impl.FavoriteServiceImpl;
import dkz97.service.impl.RouteServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    RouteService routeService = new RouteServiceImpl();

    /**
     * 分页查询的方法
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("pagequery.....");
        // 接收客户端传过来的数据，当前的页码以及cid
        String currentPageStr = request.getParameter("currentPage");
        String cidStr = request.getParameter("cid");
        String pageSizeStr = request.getParameter("pageSize");
        String rnameStr = request.getParameter("rname");

        // 处理数据，对cid，当前页数，一页展示数据数量进行判断，如果没有传递数据过来的话就设置为默认数据
        // 设置默认数据cid ,当前页数 ，以及展示数据
        int cid = 0;
        int currentPage = 1;
        int pageSize = 5;

        if (cidStr != null && cidStr.length() > 0) {
            // 如果传递的cid不为0，就是有数据，那就更改cid
            cid = Integer.parseInt(cidStr);
        }

        if (currentPageStr != null && currentPageStr.length() > 0) {
            // 传递的页码不是空，则就变成当前页码，如果为空就直接为1就好了
            currentPage = Integer.parseInt(currentPageStr);
        }

        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        }


        // 调用service的方法，查找数据
        PageBean<Route> routePageBean = routeService.pageQuery(cid, currentPage, pageSize,rnameStr);

        // 将得到的数据转化为Json，设置响应格式,并且响应给浏览器
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf8");
        mapper.writeValue(response.getOutputStream(),routePageBean);

    }


    /**
     * 用来查找一个项目的完整对象的方法
     */
    public void findOne(HttpServletRequest request,HttpServletResponse response) throws IOException {

        // 接收rid
        String ridStr = request.getParameter("rid");

        Route route = new Route();
        if ( ridStr.equals("null")){
            route = null;
        } else {
            // 调用service的方法，传入rid，返回一个完整的Route对象
            route = routeService.findOne(Integer.parseInt(ridStr));
        }

        int i = routeService.fincCountByrid(Integer.parseInt(ridStr));
        route.setCount(i);

        System.out.println(route);
        // 设置响应请求
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        // 封装成json，响应给客户端
        mapper.writeValue(response.getOutputStream(),route);
    }


    /**
     * 根据传入的id,以及在session中获取是否存在用户进行查询是否在收藏中
     */
    public void favoriteFlag(HttpServletRequest request,HttpServletResponse response) throws IOException {

        // 接收当前的rid
        String ridStr = request.getParameter("rid");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 定义用户的id
        int uid;
        if (user == null){
            // 没有用户就直接定义为0，还没登陆
            uid = 0;
        } else {
            uid = user.getUid();
        }

        // 调用favorite看是否收藏
        FavoriteService favorite = new FavoriteServiceImpl();
        boolean flag = favorite.isFavorite(Integer.parseInt(ridStr), uid);


        // 将数据写给客户端
        response.getWriter().print(flag);
    }

    /**
     * 根据传入的rid和session获取的Uid，进行收藏的添加
     */

    public void addFavorite(HttpServletRequest request,HttpServletResponse response) {

        // 通过session获取uid
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 获取rid
        String rid = request.getParameter("rid");

        int uid;
        // 判断用户是否登陆
        if (user == null) {
            return ;
        } else {
            uid = user.getUid();
        }

        // 已经登陆直接调用方法
        routeService.addFavorite(Integer.parseInt(rid),uid);

    }
}
