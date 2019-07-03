package dkz97.dao.Impl;

import dkz97.dao.FavoriteDao;
import dkz97.domain.Favorite;
import dkz97.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class FavoriteDaoImpl implements FavoriteDao {


    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 判断用户是否有收藏当前旅游线路的方法
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public Favorite findByRirAndUid(int rid, int uid) {
        Favorite favorite = null;
        try {
            String sql = "SELECT * FROM tab_favorite rid = ? and uid = ?";

            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
        } catch (Exception e) {

        }
        return favorite;
    }
}
