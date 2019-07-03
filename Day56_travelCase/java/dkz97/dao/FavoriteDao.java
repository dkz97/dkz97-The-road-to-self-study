package dkz97.dao;

import dkz97.domain.Favorite;

public interface FavoriteDao {


    /**
     * 根据传入的rid和uid查询封装到favorite
     */
    public Favorite findByRirAndUid(int rid,int uid);
}
