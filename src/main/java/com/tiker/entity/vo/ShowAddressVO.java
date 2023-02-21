package com.tiker.entity.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShowAddressVO {
    private String id;
    private String user;
    private String university;
    private String campus;
    private int isDefault;
}
