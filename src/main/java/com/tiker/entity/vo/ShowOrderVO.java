package com.tiker.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ShowOrderVO {
    //order fields
    private String orderId;
    private double price;
    private int status;
    private String requester;
    private String recipient;
    private int rate;

    //duty fields
    private String dutyId;
    private String university;
    private String campus;
    private String location;
    private String course;
    private String date;
    private String startTime;
    private String endTime;
    private String comment;

    @Override
    public String toString() {
        return "ShowOrderVO{" +
                "orderId='" + orderId + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", requester='" + requester + '\'' +
                ", recipient='" + recipient + '\'' +
                ", rate=" + rate +
                ", dutyId='" + dutyId + '\'' +
                ", university='" + university + '\'' +
                ", campus='" + campus + '\'' +
                ", location='" + location + '\'' +
                ", course='" + course + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", comment='" + comment + '\'' +
                '}';
    }
}
