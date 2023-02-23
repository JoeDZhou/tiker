package com.tiker.entity.bo;

import lombok.Data;
import java.util.Date;

@Data
public class DutyBO {
    private String id;
    private String university;
    private String campus;
    private String location;
    private String course;
    private Date date;
    private Date startTime;
    private Date endTime;
    private String comment;
}
