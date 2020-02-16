package guo.proj.javao2o.web.handler;

import guo.proj.javao2o.exceptions.ProductOperationException;
import guo.proj.javao2o.exceptions.ShopOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> handle(Exception e) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", false);
        if (e instanceof ShopOperationException) {
            modelMap.put("errMsg", e.getMessage());
        } else if (e instanceof ProductOperationException) {
            modelMap.put("errMsg", e.getMessage());
        } else {
            LOG.error("System error", e.getMessage());
            modelMap.put("errMsg", "Unknown error, please contact a client");
        }
        return modelMap;
    }

}
