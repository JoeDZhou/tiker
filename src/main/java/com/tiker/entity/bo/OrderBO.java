package com.tiker.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBO {
    private String id;
    private double price;
    private int status;
    private String requester;
    private String recipient;
    private String rate;
    private String duty;
}
