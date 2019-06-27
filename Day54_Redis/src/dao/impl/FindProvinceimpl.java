package dao.impl;

import dao.FindProvince;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import java.util.List;

public class FindProvinceimpl implements FindProvince {

    // 首先获取template 对象
    private static JdbcTemplate template =  new JdbcTemplate(JdbcUtils.getDataSrouce());

    @Override
    public  List<Province> findAll() {

        // 定义sql语句
        String sql = "SELECT * FROM province;";

        // 查询所有省份并且保存在provinces
        List<Province> provinces = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return provinces;

    }
}
