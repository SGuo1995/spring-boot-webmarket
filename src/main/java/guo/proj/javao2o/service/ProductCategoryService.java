package guo.proj.javao2o.service;

import guo.proj.javao2o.dto.ProductCategoryExecution;
import guo.proj.javao2o.entity.ProductCategory;
import guo.proj.javao2o.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getProductCategoryList(long shopId);

    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;

    /**
     * Set product_category_id of the products belong to this category to be 0, and then delete the product category
     *
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;
}
