package com.tiker.entity.bo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserBO {
    private String id;
    private String account;
    private String nickname;
    private String phone;
    private String password;
}
