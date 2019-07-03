package dkz97.service;

import dkz97.domain.PageBean;
import dkz97.domain.Route;

public interface RouteService {

    /**
     * 根据传入的id，当前页码 以及一页的数量来 进行分页查询，然后将查询到的数据封装到pageBean的list集合中，并且一条一条数据是Route对象
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize,String rname);


    /**
     * 根据客户端请求的rid,调用Dao来查询一个完整的Route对象
     */
    public Route findOne(int rid);

    /**
     * 根据传入的rid,来进行收藏次数的查询
     */
    public int fincCountByrid(int rid);

    /**
     * 根据传入的uid和rid进行添加
     *
     */
    public void addFavorite(int rid,int uid);
}
