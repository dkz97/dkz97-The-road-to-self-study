package dkz97.dao.Impl;

import dkz97.dao.RouteImgDao;
import dkz97.domain.Route;
import dkz97.domain.RouteImg;
import dkz97.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteImgDaoimpl implements RouteImgDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据传入的rid,查询，对应的rid的图片对象
     * @param rid
     * @return
     */
    @Override
    public List<RouteImg> findRouteImg(int rid) {
        String sql = "SELECT * FROM tab_route_img WHERE rid=?";

        List<RouteImg> query = template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);

        return query;
    }

}
