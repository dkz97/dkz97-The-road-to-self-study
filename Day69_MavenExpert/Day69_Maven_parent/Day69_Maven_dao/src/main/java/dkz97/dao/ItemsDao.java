package dkz97.dao;

import dkz97.domain.Items;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemsDao")
public interface ItemsDao {

    /**
     * 查询所有的方法
     */
    public List<Items> findAll();


}

