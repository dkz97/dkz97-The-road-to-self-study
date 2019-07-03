package dkz97.service;

import dkz97.domain.Category;

import java.util.List;

public interface CategoryService {


    /**
     * 查询导航栏的所有种类
     */
    public List<Category> findAll();
}
