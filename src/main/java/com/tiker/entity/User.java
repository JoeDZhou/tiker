package com.tiker.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String password;
    private String phoneNumber;
    private String nickname;
    private String college;
}
