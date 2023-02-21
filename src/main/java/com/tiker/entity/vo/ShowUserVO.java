package com.tiker.entity.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShowUserVO {
    private String id;
    private String account;
    private String nickname;
    private String phone;
}
