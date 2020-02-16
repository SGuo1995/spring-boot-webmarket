package guo.proj.javao2o.service;

import guo.proj.javao2o.entity.ProductSellDaily;

import java.util.Date;
import java.util.List;

public interface ProductSellDailyService {

    public void dailyCalculate();

    List<ProductSellDaily> listProductSellDaily(ProductSellDaily productSellDailyCondition, Date beginTime, Date endTime);
}
