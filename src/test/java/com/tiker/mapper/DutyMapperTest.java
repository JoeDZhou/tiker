package com.tiker.mapper;

import com.tiker.dao.DutyMapper;
import com.tiker.entity.bo.DutyBO;
import com.tiker.util.IDGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DutyMapperTest {
    @Resource
    private DutyMapper dutyMapper;

    private String university;
    private String campus;
    private String building;
    private String schoolRoom;
    private String course;
    private Date date;
    private Date startTime;
    private Date endTime;
    private String comment;

    @Test
    public void testInsertDuty(){
        DutyBO testDuty = new DutyBO();
        testDuty.setId(IDGenerator.generateUUID(32));
        testDuty.setUniversity("testUniversity");
        testDuty.setCampus("testCampus");
        testDuty.setBuilding("testBuilding");
        testDuty.setSchoolRoom("testSchoolRoom");
        testDuty.setCourse("testCourse");
        testDuty.setDate(new Date());
        testDuty.setStartTime(new Date());
        testDuty.setEndTime(new Date());
        testDuty.setComment("testComment");

        int insertResult = dutyMapper.insertDuty(testDuty);

        assertEquals(insertResult, 1);
    }
}
