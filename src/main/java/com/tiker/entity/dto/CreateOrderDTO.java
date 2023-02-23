package com.tiker.entity.dto;

import lombok.Data;

@Data
public class CreateOrderDTO {
    //Duty fields
    private String university;
    private String campus;
    private String location;
    private String course;
    private String date;
    private String startTime;
    private String endTime;
    private String comment;
    //Order fields
    private Double price;
    private String requester;
}
