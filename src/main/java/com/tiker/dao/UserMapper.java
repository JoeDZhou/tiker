package com.tiker.dao;

import com.tiker.entity.bo.UserBO;
import com.tiker.entity.bo.WxUserBo;
import com.tiker.entity.vo.ShowUserVO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int insertUser(UserBO user);

    UserBO getUserByIdOrPhone(@Param("id") String id, @Param("phone") String phone);

    String getUserByOpenid(@Param("openid") String openid);

    ShowUserVO getUserBaseInfoByOpenid(@Param("openid") String openid);

    int updateUserBaseInfo(@Param("userId") String userId, @Param("nickname") String nickname, @Param("phone") String phone);

    int insertNewWxUser(WxUserBo wxUserBo);
}
