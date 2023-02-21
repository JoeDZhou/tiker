package com.tiker.mapper;

import com.tiker.dao.UserMapper;
import com.tiker.entity.bo.UserBO;
import com.tiker.util.IDGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsertUser(){
        UserBO testUser1 = new UserBO();
        testUser1.setId(IDGenerator.generateUUID(32));
        testUser1.setPhone("17871940631");
        testUser1.setPassword("testPassword");
        testUser1.setNickname("testNickname");
        testUser1.setAccount("testCollege");

        int user1InsertResult = userMapper.insertUser(testUser1);
        assertEquals(user1InsertResult, 1);
    }
}
