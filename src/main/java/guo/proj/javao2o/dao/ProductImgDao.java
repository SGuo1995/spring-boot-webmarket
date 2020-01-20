package guo.proj.javao2o.dao;


import guo.proj.javao2o.entity.ProductImg;

import java.util.List;

public interface ProductImgDao {

    /**
     * list images of product by productId
     *
     * @param productId
     * @return
     */
    List<ProductImg> queryProductImgList(long productId);

    /**
     * batch add product images
     *
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);

    /**
     * delete all detail images under product
     *
     * @param productId
     * @return
     */
    int deleteProductImgByProductId(long productId);
}
