package guo.proj.javao2o.service;

import guo.proj.javao2o.dto.ImageHolder;
import guo.proj.javao2o.dto.ShopExecution;
import guo.proj.javao2o.entity.Shop;
import guo.proj.javao2o.exceptions.ShopOperationException;

public interface ShopService {
    /**
     * return shop list according to shop condition
     *
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

    Shop getByShopId(long shopId);

    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
