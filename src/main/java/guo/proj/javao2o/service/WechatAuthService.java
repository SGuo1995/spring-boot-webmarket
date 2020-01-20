package guo.proj.javao2o.service;

import guo.proj.javao2o.dto.WechatAuthExecution;
import guo.proj.javao2o.entity.WechatAuth;
import guo.proj.javao2o.exceptions.WechatAuthOperationException;

public interface WechatAuthService {

    /**
     * 通过openId查找平台对应的微信帐号
     *
     * @param openId
     * @return
     */
    WechatAuth getWechatAuthByOpenId(String openId);

    /**
     * 注册本平台的微信帐号
     *
     * @param wechatAuth
     * @return
     * @throws RuntimeException
     */
    WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException;

}
