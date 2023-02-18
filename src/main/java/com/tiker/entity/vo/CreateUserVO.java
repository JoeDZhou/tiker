package com.tiker.entity.vo;

import lombok.Data;

@Data
public class CreateUserVO {
    private String phoneNumber;
    private String password;
    private String nickname;
    private String college;
}
