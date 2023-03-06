package com.tiker.dao;

import com.tiker.entity.bo.UserBO;
import com.tiker.entity.bo.WxUserBo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int insertUser(UserBO user);

    UserBO getUserByIdOrPhone(@Param("id") String id, @Param("phone") String phone);

    String getUserByOpenid(@Param("openid") String openid);

    int insertNewWxUser(WxUserBo wxUserBo);
}
