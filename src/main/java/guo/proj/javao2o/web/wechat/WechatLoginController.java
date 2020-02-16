package guo.proj.javao2o.web.wechat;

import guo.proj.javao2o.dto.UserAccessToken;
import guo.proj.javao2o.dto.WechatAuthExecution;
import guo.proj.javao2o.dto.WechatUser;
import guo.proj.javao2o.entity.PersonInfo;
import guo.proj.javao2o.entity.WechatAuth;
import guo.proj.javao2o.enums.WechatAuthStateEnum;
import guo.proj.javao2o.service.PersonInfoService;
import guo.proj.javao2o.service.WechatAuthService;
import guo.proj.javao2o.util.wechat.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("wechatlogin")
/**
 * 获取关注公众号之后的微信用户信息的接口，如果在微信浏览器里访问
 https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9e2514412c4aefe5&redirect_uri=http://47.90.244.176/javao2o/wechatlogin/logincheck&role_type=1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
 * 则这里将会获取到code,之后再可以通过code获取到access_token 进而获取到用户信息
 *
 * @author xiangze
 *
 */
public class WechatLoginController {

    private static Logger log = LoggerFactory.getLogger(WechatLoginController.class);
    private static final String FRONTEND = "1";
    private static final String SHOPEND = "2";
    @Autowired
    private WechatAuthService wechatAuthService;
    @Autowired
    private PersonInfoService personInfoService;

    @RequestMapping(value = "/logincheck", method = {RequestMethod.GET})
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        log.debug("wechat login get...");
        // 获取微信公众号传输过来的code,通过code可获取access_token,进而获取用户信息
        String code = request.getParameter("code");
        // 这个state可以用来传我们自定义的信息，方便程序调用，这里也可以不用
        String roleType = request.getParameter("state");
        log.debug("wechat login code:" + code);
        WechatUser user = null;
        String openId = null;
        WechatAuth wechatAuth = null;

        if (null != code) {
            UserAccessToken token;
            try {
                // 通过code获取access_token
                token = WechatUtil.getUserAccessToken(code);
                log.debug("wechat login token:" + token.toString());
                // 通过token获取accessToken
                String accessToken = token.getAccessToken();
                // 通过token获取openId
                openId = token.getOpenId();
                // 通过access_token和openId获取用户昵称等信息
                user = WechatUtil.getUserInfo(accessToken, openId);
                log.debug("wechat login user:" + user.toString());
                request.getSession().setAttribute("openId", openId);
                wechatAuth = wechatAuthService.getWechatAuthByOpenId(openId);
            } catch (IOException e) {
                log.error("error in getUserAccessToken or getUserInfo or findByOpenId: " + e.toString());
                e.printStackTrace();
            }
        }
        //If wechatAuth is null, we need to create account as well as person info
        if (wechatAuth == null) {
            PersonInfo personInfo = WechatUtil.getPersonInfoFromRequest(user);
            wechatAuth = new WechatAuth();
            wechatAuth.setOpenId(openId);
            if (roleType.equals(FRONTEND)) {
                personInfo.setUserType(1);
            } else {
                personInfo.setUserType(2);
            }
            wechatAuth.setPersonInfo(personInfo);
            WechatAuthExecution wae = wechatAuthService.register(wechatAuth);
            if (wae.getState() != WechatAuthStateEnum.SUCCESS.getState()) {
                return null;
            } else {
                personInfo = personInfoService.getPersonInfoById(wechatAuth.getPersonInfo().getUserId());
                request.getSession().setAttribute("user", personInfo);
            }
        }
        //if user click frontend button in wechat, go to frontend, otherwise go to shopadmin
        if (FRONTEND.equals(roleType)) {
            return "frontend/index";
        } else {
            return "shopadmin/shoplist";
        }
    }
}

