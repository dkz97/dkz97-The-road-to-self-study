package dkz97.service.impl;

import dkz97.dao.Impl.RouteDaoImpl;
import dkz97.dao.Impl.RouteImgDaoimpl;
import dkz97.dao.Impl.SellerDaoImpl;
import dkz97.dao.RouteDao;
import dkz97.dao.RouteImgDao;
import dkz97.dao.SellerDao;
import dkz97.domain.PageBean;
import dkz97.domain.Route;
import dkz97.domain.RouteImg;
import dkz97.domain.Seller;
import dkz97.service.RouteService;

import javax.servlet.annotation.WebServlet;
import java.util.List;


public class RouteServiceImpl implements RouteService {

    RouteDao routeDao = new RouteDaoImpl();
    RouteImgDao routeImgDao = new RouteImgDaoimpl();
    SellerDao sellerDao = new SellerDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname) {

        // 创建pageBean对象，然后根据查询返回的数值以及计算的数值给pageBean对象设置
        PageBean<Route> pageBean = new PageBean<>();

        // 查询一共有多少数据量
        int totalCount = routeDao.findTotalCount(cid,rname);
        pageBean.setTotalCount(totalCount);

        // 查询计算出分页查询开始的索引
        int start = (currentPage - 1) * pageSize;

        // 计算总的页数，总页数等于总数据/一页的数据，但是如果除出来为单数的话总页数要加一
        int totalPage = (totalCount % pageSize) == 0 ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        pageBean.setTotalPage(totalPage);

        // 调用RouteDao的方法 进行分页查询,返回的数组设置给pagebean对象
        List<Route> routes = routeDao.findByPage(cid, start, pageSize,rname);
        pageBean.setList(routes);
        // 把剩下的数组都存储到对象中
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);



        return pageBean;

    }


    /**
     * 先查询route对象，然后再查询对应的图片集合，再查询商家信息
     * @param rid
     * @return
     */
    @Override
    public Route findOne(int rid) {

        // 查询一个route对象
        Route route = routeDao.findOne(rid);


        // 查询route的图片集
        List<RouteImg> routeImg = routeImgDao.findRouteImg(rid);

        // 把图片集设置在route对象中
        route.setRouteImgList(routeImg);

        // 查询商家信息
        Seller seller = sellerDao.findSeller(route.getSid());

        // 把商家信息设置到对象中
        route.setSeller(seller);

        return route;

    }


    /**
     * 根据传入的rid进行收藏次数的查询
     * @param rid
     * @return
     */
    @Override
    public int fincCountByrid(int rid) {

        int countByRid = routeDao.findCountByRid(rid);
        return countByRid;
    }


    /**
     * 增加favorite
     * @param rid
     * @param uid
     */
    @Override
    public void addFavorite(int rid, int uid) {

        routeDao.addFavorite(rid,uid);

    }
}
