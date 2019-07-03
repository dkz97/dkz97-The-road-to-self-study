package dkz97.dao.Impl;

import dkz97.dao.SellerDao;
import dkz97.domain.Seller;
import dkz97.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SellerDaoImpl implements SellerDao {


    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据传入的商家的sid来获取商家信息
     * @param sid
     * @return
     */
    @Override
    public Seller findSeller(int sid) {

        String sql = "SELECT * FROM tab_seller WHERE sid=?";

        Seller seller = template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), sid);

        return seller;

    }
}
