package dkz97.dao;

import dkz97.domain.Route;

import java.util.List;

public interface RouteDao {

    /**
     * 可以根据传入的当前页数，一页展示的数据量来进行分页查询
     */

    public List<Route> findByPage(int cid,int start,int PageSize,String rname);

    /**
     * 查询数据的总量
     * @param cid
     * @return
     */
    public int findTotalCount(int cid,String rname);


    /**
     * 根据rid，查询当前的Route对象
     *
     */
    public Route findOne(int rid);

    /**
     * 根据rid,查询当前的收藏次数
     */
    public int findCountByRid(int rid);

    /**
     * 根据传入的rid 和 uid，进行收藏的添加
     */

    public void addFavorite(int rid,int uid);

}
