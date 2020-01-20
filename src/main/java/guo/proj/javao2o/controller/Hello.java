package guo.proj.javao2o.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello a SpringBoot!";
    }

//    @RequestMapping("/fuck")
//    public String fck(){
//        return "fpc";
//    }
}
