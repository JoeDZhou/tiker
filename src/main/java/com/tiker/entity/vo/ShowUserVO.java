package com.tiker.entity.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShowUserVO {
    private String imgUrl;
    private String nickname;
    private String phone;
    private String university;
    private String campus;
}
