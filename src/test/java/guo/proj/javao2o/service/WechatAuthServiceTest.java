package guo.proj.javao2o.service;


import guo.proj.javao2o.dto.WechatAuthExecution;
import guo.proj.javao2o.entity.PersonInfo;
import guo.proj.javao2o.entity.WechatAuth;
import guo.proj.javao2o.enums.WechatAuthStateEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class WechatAuthServiceTest {

    @Autowired
    private WechatAuthService wechatAuthService;

    @Test
    public void testRegister() {
        WechatAuth wechatAuth = new WechatAuth();
        wechatAuth.setOpenId("dfrrrrrrrr");
        wechatAuth.setCreateTime(new Date());
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserType(1);
        personInfo.setName("test of register");
        personInfo.setCreateTime(new Date());
        wechatAuth.setPersonInfo(personInfo);
        WechatAuthExecution wae = wechatAuthService.register(wechatAuth);
        assertEquals(wae.getState(), WechatAuthStateEnum.SUCCESS.getState());
        wechatAuth = wechatAuthService.getWechatAuthByOpenId("dfrrrrrrrr");
        System.out.println(wechatAuth.getPersonInfo().getName());
    }
}
