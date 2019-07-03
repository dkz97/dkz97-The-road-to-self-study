package dkz97.dao.Impl;

import dkz97.dao.RouteDao;
import dkz97.domain.Route;
import dkz97.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteDaoImpl implements RouteDao {


    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 根据开始的索引以及一页展示的数据，还有cid，来进行分页展示
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        String sql = "SELECT * FROM tab_route WHERE 1=1 ";
        StringBuilder sb = new StringBuilder(sql);

        List lis = new ArrayList();
        if (rname != null && rname.length() > 0 && !rname.equals("null")) {
            rname = "%" + rname + "%";
            sb.append(" and rname like ?");
            lis.add(rname);
        }

        if (cid >= 1 && cid <= 8) {
            sb.append(" and cid = ? ");
            lis.add(cid);
        }

        sb.append(" limit ? , ?");
        lis.add(start);
        lis.add(pageSize);

        sql = sb.toString();
        System.out.println(sql);

        List<Route> query = template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), lis.toArray());

        return query;
    }


    /**
     * 查询一共的数据总数是多少
     * @param cid
     * @return
     */
    @Override
    public int findTotalCount(int cid,String rname) {
        String sql = "SELECT count(*) from tab_route WHERE 1=1 ";

        StringBuilder sb = new StringBuilder(sql);
        List lis = new ArrayList();
        if (rname != null && rname.length() > 0 && !rname.equals("null")) {
            rname = "%" + rname + "%";
            sb.append(" and rname like ?");
            lis.add(rname);
        }

        if (cid != 0 ) {
            sb.append(" and cid = ? ");
            lis.add(cid);
        }

        sql = sb.toString();

        // toArray，要先转成数组才能进行传参
        Integer integer = template.queryForObject(sql, Integer.class, lis.toArray());

        return integer;
    }


    /**
     * 根据给予的rid，查询route对象返回route
     * @param rid
     * @return
     */
    @Override
    public Route findOne(int rid) {

        String sql = "SELECT * FROM tab_route WHERE rid=?";

        Route route = template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);

        return route;
    }


    /**
     * 根据当前的rid查询收藏次数
     * @param rid
     * @return
     */
    @Override
    public int findCountByRid(int rid) {
        String sql = "SELECT count(*) FROM tab_favorite WHERE rid=?";

        return template.queryForObject(sql,Integer.class,rid);
    }


    /**
     * 根据传入的rid和uid，进行收藏的添加
     * @param rid
     * @param uid
     */
    @Override
    public void addFavorite(int rid, int uid) {
        String sql = "INSERT INTO tab_favorite values(?,?,?) ";

        template.update(sql,rid,new Date(),uid);
    }
}
