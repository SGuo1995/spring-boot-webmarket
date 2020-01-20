package guo.proj.javao2o.service;

import guo.proj.javao2o.dto.LocalAuthExecution;
import guo.proj.javao2o.entity.LocalAuth;
import guo.proj.javao2o.exceptions.LocalAuthOperationException;

public interface LocalAuthService {
    /**
     * 通过帐号和密码获取平台帐号信息
     *
     * @param userName
     * @return
     */
    LocalAuth getLocalAuthByUsernameAndPwd(String userName, String password);

    /**
     * 通过userId获取平台帐号信息
     *
     * @param userId
     * @return
     */
    LocalAuth getLocalAuthByUserId(long userId);

    /**
     * 绑定微信，生成平台专属的帐号
     *
     * @param localAuth
     * @return
     * @throws RuntimeException
     */
    LocalAuthExecution bindLocalAuth(LocalAuth localAuth) throws LocalAuthOperationException;

    /**
     * @param userId
     * @param username
     * @param password
     * @param newPassword
     * @return
     * @throws LocalAuthOperationException
     */
    LocalAuthExecution modifyLocalAuth(Long userId, String username, String password, String newPassword)
            throws LocalAuthOperationException;
}
