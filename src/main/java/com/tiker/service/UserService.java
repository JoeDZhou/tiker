package com.tiker.service;

import com.tiker.entity.vo.CreateUserVO;

public interface UserService {
    int userRegister(CreateUserVO createUserVO);

    String userLogin();
}
