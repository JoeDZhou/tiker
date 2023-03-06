package com.tiker.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class WxUserBo {
    private String openid;
    private String nickname;
    private Date createdTime;
    private Date lastLoginTime;
    private String phone;
}
