package guo.proj.javao2o.service;

import guo.proj.javao2o.dto.ImageHolder;
import guo.proj.javao2o.dto.ProductExecution;
import guo.proj.javao2o.entity.Product;
import guo.proj.javao2o.exceptions.ProductOperationException;

import java.util.List;

public interface ProductService {

    /**
     * Add product info and process its image
     *
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail,
                                List<ImageHolder> productImgList) throws ProductOperationException;

    Product getProductById(long productId);

    ProductExecution modifyProduct(Product product, ImageHolder thumbnail,
                                   List<ImageHolder> productImgList) throws ProductOperationException;

    /**
     * 查询商品列表并分页，可输入的条件有： 商品名（模糊），商品状态，店铺Id,商品类别
     *
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

}
