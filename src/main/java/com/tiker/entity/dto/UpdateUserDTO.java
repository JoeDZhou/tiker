package com.tiker.entity.dto;

import lombok.Data;

@Data
public class UpdateUserDTO {
    private String userId;
    private String nickname;
    private String university;
    private String campus;
    private String phone;
}
