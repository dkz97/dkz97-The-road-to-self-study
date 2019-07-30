package dkz97.service;

import dkz97.domain.Items;

import java.util.List;

public interface IItemsService {

    /**
     * 查询所有
     */
    public List<Items> findAll();
}
