package com.tiker.controller;

import com.tiker.entity.dto.CreateUserDTO;
import com.tiker.entity.dto.RestResultDTO;
import com.tiker.entity.dto.WXLoginResultDTO;
import com.tiker.entity.vo.ShowUserVO;
import com.tiker.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

//    @PostMapping("/register")
//    public RestResultDTO register(@RequestBody CreateUserDTO createUserDTO) {
//        int createNum = userService.userRegister(createUserDTO);
//        if (createNum > 0) {
//            return new RestResultDTO(0, "Success", null);
//        } else {
//            return new RestResultDTO(1, "User register failed", null);
//        }
//    }

    @PostMapping("/login")
    public RestResultDTO login(@RequestParam String code) throws Exception {
        WXLoginResultDTO loginResult = userService.userLogin(code);
        System.out.println("Open id in controller: " + loginResult);
        if (loginResult.getOpenid() != null) {
            return new RestResultDTO(0, "Success", loginResult.getOpenid());
        } else {
            return new RestResultDTO(1, "Login failed", loginResult.getErrmsg());
        }
    }

    @GetMapping("/getBaseInfo")
    public RestResultDTO getBaseInfo(@RequestParam String userId) {
        ShowUserVO userVO = userService.getUserBaseInfo(userId);
        if (userVO != null) {
            return new RestResultDTO(0, "Success", userVO);
        } else {
            return new RestResultDTO(1, "Get user base info failed", null);
        }
    }
}
