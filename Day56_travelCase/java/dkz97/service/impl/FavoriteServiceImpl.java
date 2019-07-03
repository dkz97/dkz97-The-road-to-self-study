package dkz97.service.impl;

import dkz97.dao.FavoriteDao;
import dkz97.dao.Impl.FavoriteDaoImpl;
import dkz97.domain.Favorite;
import dkz97.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {

    FavoriteDao favoriteDao = new FavoriteDaoImpl();

    /**
     * 根据旅游线路的id和用户的id查询当前旅游线路是否给用户收藏
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public boolean isFavorite(int rid, int uid) {

        // 调用dao的查询方法
        Favorite byRirAndUid = favoriteDao.findByRirAndUid(rid, uid);

        if (byRirAndUid != null) {
            return true;
        } else {
            return false;
        }


    }
}
