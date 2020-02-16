package guo.proj.javao2o.service.impl;

import guo.proj.javao2o.dao.ProductSellDailyDao;
import guo.proj.javao2o.entity.ProductSellDaily;
import guo.proj.javao2o.service.ProductSellDailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductSellDailyServiceImpl implements ProductSellDailyService {

    private static final Logger log = LoggerFactory.getLogger(ProductSellDailyServiceImpl.class);
    @Autowired
    private ProductSellDailyDao productSellDailyDao;

    @Override
    public void dailyCalculate(){
        log.info("Quartz running");
        //use user-product-map to generate...
        productSellDailyDao.insertProductSellDaily();
        //set the rest of products which sales num is 0;
        productSellDailyDao.insertDefaultProductSellDaily();


    }

    @Override
    public List<ProductSellDaily> listProductSellDaily(ProductSellDaily productSellDailyCondition, Date beginTime, Date endTime) {
        return productSellDailyDao.queryProductSellDailyList(productSellDailyCondition, beginTime, endTime);
    }
}
