package com.tiker.entity.bo;

import lombok.Data;

import java.util.Date;

@Data
public class GetOrderBO {
    private String university;
    private String campus;
    private Date date;
    private Date startTime;
    private Date endTime;
}
