package com.tiker.util;

import com.tiker.util.IDGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class IDGeneratorTest {
    @Test
    public void testGenerateId() {
        String ID = IDGenerator.generateUUID(35);
        System.out.println("ID:" + ID);
        assertEquals(ID.length(), 35);
    }
}
