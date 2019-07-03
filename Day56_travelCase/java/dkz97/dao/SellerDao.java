package dkz97.dao;

import dkz97.domain.Seller;

public interface SellerDao {


    /**
     * 根据rid查询对应的商家信息
     */
    public Seller findSeller(int sid);
}
