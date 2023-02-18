package com.tiker.service;

import com.tiker.entity.dto.CreateOrderDTO;
import com.tiker.util.IDGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Resource
    private OrderService orderService;

    @Test
    public void testCreateOrder() throws Exception {
        CreateOrderDTO createOrderDto = new CreateOrderDTO();
        createOrderDto.setUniversity("testUniversity12356456");
        createOrderDto.setCampus("testCampus");
        createOrderDto.setBuilding("testBuilding");
        createOrderDto.setSchoolRoom("testSchoolRoom");
        createOrderDto.setCourse("testCourse");
        createOrderDto.setDate("2023-01-02");
        createOrderDto.setStartTime("11:30:30");
        createOrderDto.setEndTime("13:30:33");
        createOrderDto.setComment("testComment");

        createOrderDto.setPrice(45.55);
        createOrderDto.setRequester(IDGenerator.generateUUID(32));

        int createResult = orderService.createOrder(createOrderDto);
        assertEquals(1, createResult);
    }
}
