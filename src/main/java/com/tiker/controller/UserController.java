package com.tiker.controller;

import com.tiker.entity.dto.CreateUserDTO;
import com.tiker.entity.dto.RestResultDTO;
import com.tiker.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public RestResultDTO register(@RequestBody CreateUserDTO createUserDTO) {
        int createNum = userService.userRegister(createUserDTO);
        if (createNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "User register failed", null);
        }
    }
}
