package com.tiker.entity.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WXLoginResultDTO {
    private String errcode;
    private String errmsg;
    private String session_key;
    private String openid;
}
