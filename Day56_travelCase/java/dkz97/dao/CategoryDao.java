package dkz97.dao;

import dkz97.domain.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * 查询所有导航栏的名称
     * @return
     */
    public List<Category> findAll();
}
