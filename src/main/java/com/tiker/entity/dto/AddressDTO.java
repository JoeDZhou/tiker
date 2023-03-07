package com.tiker.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddressDTO {
    private String id;
    private String user;
    private String university;
    private String campus;
    private int isDefault;
}
