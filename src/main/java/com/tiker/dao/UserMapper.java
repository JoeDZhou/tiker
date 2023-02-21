package com.tiker.dao;

import com.tiker.entity.bo.UserBO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int insertUser(UserBO user);

    UserBO getUserByIdOrPhone(@Param("id") String id, @Param("phone") String phone);
}
