package guo.proj.javao2o.dao;

import guo.proj.javao2o.entity.ProductSellDaily;
import guo.proj.javao2o.entity.Shop;

import org.junit.Ignore;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class ProductSellDailyDaoTest {
    @Autowired
    private ProductSellDailyDao productSellDailyDao;

    /**
     * 测试添加功能
     *
     * @throws Exception
     */
    @Test
    public void testAInsertProductSellDaily() throws Exception {
        // 创建商品日销量统计
        int effectedNum = productSellDailyDao.insertProductSellDaily();
        assertEquals(3, effectedNum);
    }

    /**
     * 测试添加功能
     *
     * @throws Exception
     */
    @Test
    public void testBInsertDefaultProductSellDaily() throws Exception {
        // 创建商品日销量统计
        int effectedNum = productSellDailyDao.insertDefaultProductSellDaily();
        assertEquals(10, effectedNum);
    }

    /**
     * 测试查询功能
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testCQueryProductSellDaily() throws Exception {
        ProductSellDaily productSellDaily = new ProductSellDaily();
        // 叠加店铺去查询
        Shop shop = new Shop();
        shop.setShopId(36L);
        productSellDaily.setShop(shop);
        List<ProductSellDaily> productSellDailyList = productSellDailyDao.queryProductSellDailyList(productSellDaily,
                null, null);
        System.out.println(productSellDailyList.size());
    }
}
