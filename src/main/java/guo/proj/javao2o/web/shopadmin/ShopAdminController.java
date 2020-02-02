package guo.proj.javao2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin", method = {RequestMethod.GET})
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation() {
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/productoperation")
    public String productoperation() {
        return "shop/productoperation";
    }

    @RequestMapping(value = "/productmanagement")
    public String productmanagement() {
        return "shop/productmanagement";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList() {
        return "shop/shoplist";
    }

    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/awardmanagement")
    public String awardManagement() {
        return "shop/awardmanagement";
    }
    @RequestMapping(value = "/productcategorymanagement")
    public String productCategoryManagement() {
        return "shop/productcategorymanagement";
    }
    @RequestMapping(value = "/awarddelivercheck")
    public String awardDeliverCheck() {
        return "shop/awarddelivercheck";
    }
    @RequestMapping(value = "/usershopcheck")
    public String userShopCheck() {
        return "shop/usershopcheck";
    }
    @RequestMapping(value = "/shopauthmanagement")
    public String shopAuthManagement() {
        return "shop/shopauthmanagement";
    }
    @RequestMapping(value = "/shopauthedit")
    public String shopAuthEdit() {
        return "shop/shopauthedit";
    }

    @RequestMapping(value = "/operationfail")
    public String operationFail() {
        return "shop/operationfail";
    }

    @RequestMapping(value = "/operationsuccess")
    public String operationSuccess() {
        return "shop/operationsuccess";
    }

}
