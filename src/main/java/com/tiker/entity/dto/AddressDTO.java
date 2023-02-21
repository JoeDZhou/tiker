package com.tiker.entity.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String id;
    private String user;
    private String university;
    private String campus;
    private int isDefault;
}
