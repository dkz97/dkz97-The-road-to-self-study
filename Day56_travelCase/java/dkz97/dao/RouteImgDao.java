package dkz97.dao;

import dkz97.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {


    /**
     * 根据rid，查询出当前的图片信息
     */

    public List<RouteImg> findRouteImg(int rid);
}
