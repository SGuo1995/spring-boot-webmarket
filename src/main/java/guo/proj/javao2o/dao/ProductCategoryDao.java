package guo.proj.javao2o.dao;


import guo.proj.javao2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {

    /**
     * Query Product Category using shop Id
     */
    List<ProductCategory> queryProductCategoryList(long shopId);

    /**
     * batch insert product Category
     *
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     * Delete product category
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}
