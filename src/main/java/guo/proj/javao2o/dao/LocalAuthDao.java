package guo.proj.javao2o.dao;


import guo.proj.javao2o.entity.LocalAuth;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface LocalAuthDao {

    /**
     * @param username
     * @param password
     * @return
     */
    LocalAuth queryLocalByUserNameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * @param userId
     * @return
     */
    LocalAuth queryLocalByUserId(@Param("userId") long userId);

    /**
     * @param localAuth
     * @return
     */
    int insertLocalAuth(LocalAuth localAuth);

    /**
     * @param userId
     * @param username
     * @param password
     * @param lastEditTime
     * @return
     */
    int updateLocalAuth(@Param("userId") Long userId, @Param("username") String username, @Param("password") String password,
                        @Param("newPassword") String newPassword, @Param("lastEditTime") Date lastEditTime);


}
