package guo.proj.javao2o.web.frontend;

import guo.proj.javao2o.entity.Product;
import guo.proj.javao2o.service.ProductService;
import guo.proj.javao2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/frontend")
public class ProductDetailController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/listproductdetailpageinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listProductDetailPageInfo(HttpServletRequest request) {
        long productId = HttpServletRequestUtil.getLong(request, "productId");
        Map<String, Object> modelMap = new HashMap<>();
        Product product = null;
        if (productId != -1) {
            product = productService.getProductById(productId);
            modelMap.put("success", true);
            modelMap.put("product", product);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty productId");

        }
        return modelMap;
    }

}
