package guo.proj.javao2o.dao;

import guo.proj.javao2o.entity.PersonInfo;
import guo.proj.javao2o.entity.Shop;
import guo.proj.javao2o.entity.UserShopMap;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class UserShopMapDaoTest {
    @Autowired
    private UserShopMapDao userShopMapDao;

    /**
     * 测试添加功能
     *
     * @throws Exception
     */
    @Test
    public void testAInsertUserShopMap() throws Exception {
        // 创建用户店铺积分统计信息1
        UserShopMap userShopMap = new UserShopMap();
        PersonInfo customer = new PersonInfo();
        customer.setUserId(1L);
        userShopMap.setUser(customer);
        Shop shop = new Shop();
        shop.setShopId(36L);
        userShopMap.setShop(shop);
        userShopMap.setCreateTime(new Date());
        userShopMap.setPoint(1);
        int effectedNum = userShopMapDao.insertUserShopMap(userShopMap);
        // 创建用户店铺积分统计信息2
        UserShopMap userShopMap2 = new UserShopMap();
        PersonInfo customer2 = new PersonInfo();
        customer2.setUserId(10L);
        userShopMap2.setUser(customer2);
        Shop shop2 = new Shop();
        shop2.setShopId(48L);
        userShopMap2.setShop(shop2);
        userShopMap2.setCreateTime(new Date());
        userShopMap2.setPoint(1);
        effectedNum = userShopMapDao.insertUserShopMap(userShopMap2);
        assertEquals(1, effectedNum);
    }

    /**
     * 测试查询功能
     *
     * @throws Exception
     */
    @Test
    public void testBQueryUserShopMap() throws Exception {
        UserShopMap userShopMap = new UserShopMap();
        // 查全部
        List<UserShopMap> userProductMapList = userShopMapDao.queryUserShopMapList(userShopMap, 0, 2);
        assertEquals(2, userProductMapList.size());
        int count = userShopMapDao.queryUserShopMapCount(userShopMap);
        assertEquals(2, count);
        // 按店铺去查询
        Shop shop = new Shop();
        shop.setShopId(36L);
        userShopMap.setShop(shop);
        userProductMapList = userShopMapDao.queryUserShopMapList(userShopMap, 0, 3);
        assertEquals(1, userProductMapList.size());
        count = userShopMapDao.queryUserShopMapCount(userShopMap);
        assertEquals(1, count);
        // 按用户Id和店铺查询
        userShopMap = userShopMapDao.queryUserShopMap(1, 36);
        assertEquals("test", userShopMap.getUser().getName());
    }

    /**
     * 测试更新功能
     *
     * @throws Exception
     */
    @Test
    public void testCUpdateUserShopMap() throws Exception {
        UserShopMap userShopMap = new UserShopMap();
        userShopMap = userShopMapDao.queryUserShopMap(1, 36);
        assertTrue("Error, points not equal！", 1 == userShopMap.getPoint());
        userShopMap.setPoint(2);
        int effectedNum = userShopMapDao.updateUserShopMapPoint(userShopMap);
        assertEquals(1, effectedNum);
    }
}

