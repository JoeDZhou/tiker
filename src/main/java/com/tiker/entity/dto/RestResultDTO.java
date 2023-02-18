package com.tiker.entity.dto;

import lombok.Data;

@Data
public class RestResultDTO {
    private int statusCode;
    private String message;
    private Object payload;

    public RestResultDTO(int statusCode, String message, Object payload) {
        this.statusCode = statusCode;
        this.message = message;
        this.payload = payload;
    }
}
