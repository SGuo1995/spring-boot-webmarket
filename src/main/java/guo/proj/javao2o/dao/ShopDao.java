package guo.proj.javao2o.dao;


import guo.proj.javao2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    /**
     * @param shopCondition
     * @param rowIndex      query from which row
     * @param pageSize      rows returned
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,
                             @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    int queryShopCount(@Param("shopCondition") Shop shopCondition);


    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * Query Shop by Id
     *
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
