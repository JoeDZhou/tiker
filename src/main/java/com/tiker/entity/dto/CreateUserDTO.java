package com.tiker.entity.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateUserDTO {
    private String phone;
    private String password;
    private String nickname;
}
