package guo.proj.javao2o.dao;

import guo.proj.javao2o.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    /**
     * query products with page set, conditions to be input: product name(roughly), shopId, product status, product category
     */
    List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int rowIndex,
                                   @Param("pageSize") int pageSize);


    /**
     * query products count
     *
     * @param productCondition
     * @return
     */
    int queryProductCount(@Param("productCondition") Product productCondition);

    /**
     * query product information through ProductId
     *
     * @param productId
     * @return
     */
    Product queryProductById(long productId);

    /**
     * insertProduct
     *
     * @param product
     * @return
     */
    int insertProduct(Product product);

    /**
     * update product
     *
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * update product category to null before delete product category
     *
     * @param productCategoryId
     * @return
     */
    int updateProductCategoryToNull(long productCategoryId);

    /**
     * delete product
     *
     * @param productId
     * @return
     */
    int deleteProduct(@Param("productId") long productId, @Param("shopId") long shopId);
}
