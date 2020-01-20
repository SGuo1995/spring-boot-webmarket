package guo.proj.javao2o.service;

import guo.proj.javao2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    public static final String SCLISTKEY = "shopcategorylist";
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
