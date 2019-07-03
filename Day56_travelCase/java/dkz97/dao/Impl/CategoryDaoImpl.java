package dkz97.dao.Impl;

import dkz97.dao.CategoryDao;
import dkz97.domain.Category;
import dkz97.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查找所有导航栏的名称
     * @return
     */
    @Override
    public List<Category> findAll() {
        String sql = "SELECT * FROM tab_category";

        List<Category> query = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        return query;
    }
}
