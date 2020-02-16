package guo.proj.javao2o.service.impl;

import guo.proj.javao2o.dao.ShopAuthMapDao;
import guo.proj.javao2o.dao.ShopDao;
import guo.proj.javao2o.dto.ImageHolder;
import guo.proj.javao2o.dto.ShopExecution;
import guo.proj.javao2o.entity.Shop;
import guo.proj.javao2o.entity.ShopAuthMap;
import guo.proj.javao2o.enums.ShopStateEnum;
import guo.proj.javao2o.exceptions.ShopOperationException;
import guo.proj.javao2o.service.ShopService;
import guo.proj.javao2o.util.ImageUtil;
import guo.proj.javao2o.util.PageCalculator;
import guo.proj.javao2o.util.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Autowired
    private ShopAuthMapDao shopAuthMapDao;

    @Override
    public Shop getByShopId(long shopId) {
        return shopDao.queryByShopId(shopId);
    }

    private final static Logger LOG = LoggerFactory.getLogger(ShopServiceImpl.class);
    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
        int count = shopDao.queryShopCount(shopCondition);
        ShopExecution se = new ShopExecution();
        if (shopList != null) {
            se.setShopList(shopList);
            se.setCount(count);
        } else {
            se.setState(ShopStateEnum.INNER_ERROR.getState());
        }

        return se;
    }

    @Override
    public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {

        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        } else {
            //1. proceed img if needed
            try {
                if (thumbnail.getImage() != null && !"".equals(thumbnail.getImageName())) {
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if (tempShop.getShopImg() != null) {
                        ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                    }
                    addShopImg(shop, thumbnail);
                }
                //2. update shop info
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnum.SUCCESS, shop);
                }
            } catch (Exception e) {
                throw new ShopOperationException("modifyShop error:" + e.getMessage());
            }
        }


    }

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, ImageHolder thumbnail) {
        //check if null
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            //set initial value of shop
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //insert shop into database
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                LOG.error("returned 0 effected numbers when inserting shop");
                throw new ShopOperationException("Fail to add Shop");
            } else {
                if (thumbnail.getImage() != null) {
                    //save img
                    try {
                        addShopImg(shop, thumbnail);
                    } catch (Exception e) {
                        LOG.error("addShopImg error:" + e.getMessage());
                        throw new ShopOperationException("Failed to add image");
                    }
                    //update img address of the shop
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0) {
                        LOG.error("failed to updated image address");
                        throw new ShopOperationException("Failed to add image");
                    }
                    ShopAuthMap shopAuthMap = new ShopAuthMap();
                    shopAuthMap.setTitle("Owner");
                    shopAuthMap.setShop(shop);
                    shopAuthMap.setLastEditTime(new Date());
                    shopAuthMap.setLastEditTime(new Date());
                    shopAuthMap.setEmployee(shop.getOwner());
                    shopAuthMap.setEnableStatus(1);
                    shopAuthMap.setTitleFlag(0);
                    try {
                        effectedNum = shopAuthMapDao.insertShopAuthMap(shopAuthMap);
                        if (effectedNum <= 0) {
                            LOG.error("addShop: authorization creation failed");

                            throw new ShopOperationException("authorization creation failed");
                        }
                    } catch (Exception e) {
                        LOG.error("insertShopAuthMap error:" + e.getMessage());

                        throw new ShopOperationException("authorization creation failed");
                    }
                }
            }

        } catch (Exception e) {
            LOG.error("add shop error:" + e.getMessage());

            throw new ShopOperationException("Failed to add shop");
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);


    }

    private void addShopImg(Shop shop, ImageHolder thumbnail) {
        //get relative path of the img fold
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
        shop.setShopImg(shopImgAddr);
    }

}
