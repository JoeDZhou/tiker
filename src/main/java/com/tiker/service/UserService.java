package com.tiker.service;

import com.tiker.entity.dto.CreateUserDTO;
import com.tiker.entity.dto.WXLoginResultDTO;
import com.tiker.entity.vo.ShowUserVO;

public interface UserService {
//    int userRegister(CreateUserDTO createUserDTO);

    WXLoginResultDTO userLogin(String code) throws Exception;

    ShowUserVO getUserBaseInfo(String userId);
}
