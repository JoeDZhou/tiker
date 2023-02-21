package com.tiker.service;

import com.tiker.entity.dto.CreateUserDTO;

public interface UserService {
    int userRegister(CreateUserDTO createUserDTO);

    String userLogin();
}
