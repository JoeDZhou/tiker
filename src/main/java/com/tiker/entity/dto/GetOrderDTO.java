package com.tiker.entity.dto;

import lombok.Data;

@Data
public class GetOrderDTO {
    private String userId;
    private String university;
    private String campus;
    private String date;
    private String startTime;
    private String endTime;
}
