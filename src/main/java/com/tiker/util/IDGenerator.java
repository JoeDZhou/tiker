package com.tiker.util;

import java.util.UUID;

public class IDGenerator {
    public static String generateUUID(int length){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        if(length <= 32){
            return uuid;
        }
        if (length > 64){
            return "";
        }
        String uuidPartTwo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, length - 32);

        return uuid + uuidPartTwo;
    }
}
