package dkz97.service;

import dkz97.domain.Favorite;

public interface FavoriteService {


    /**
     * 根据传入的rid和uid，进行收藏的判断
     */
    public boolean isFavorite (int rid,int uid);


}
