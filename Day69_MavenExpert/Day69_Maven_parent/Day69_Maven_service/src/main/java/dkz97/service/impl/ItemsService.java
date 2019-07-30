package dkz97.service.impl;

import dkz97.dao.ItemsDao;
import dkz97.domain.Items;
import dkz97.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("itemsService")
public class ItemsService implements IItemsService {

    @Autowired
    private ItemsDao itemsDao;



    /**
     * 查询所有
     * @return
     */
    @Transactional
    public List<Items> findAll() {
        return itemsDao.findAll();
    }
}
