package com.tiker.service.impl;

import com.tiker.dao.UserMapper;
import com.tiker.entity.bo.UserBO;
import com.tiker.entity.dto.CreateUserDTO;
import com.tiker.service.UserService;
import com.tiker.util.IDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int userRegister(CreateUserDTO createUserDTO) {
        validPhoneNumber(createUserDTO.getPhone());
        validPassword(createUserDTO.getPassword());
        UserBO user = new UserBO();
        user.setId(IDGenerator.generateUUID(64));
        user.setAccount(IDGenerator.generateUUID(32));
        BeanUtils.copyProperties(createUserDTO, user);

        return userMapper.insertUser(user);
    }

    private boolean validPhoneNumber(String phoneNumber) {
        String regex = "^((13[0-9])|(14(0|[5-7]|9))|(15([0-3]|[5-9]))|(16(2|[5-7]))|(17[0-8])|(18[0-9])|(19([0-3]|[5-9])))\\d{8}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(phoneNumber);
        if (!m.matches()) {
            return false;
        }

        UserBO user = userMapper.getUserByIdOrPhone(null, phoneNumber);
        if (user != null) {
            return false;
        }

        return true;
    }

    private boolean validPassword(String password) {
        if (password.length() < 8 || password.length() > 32){
            return false;
        }

        return true;
    }

    @Override
    public String userLogin() {
        return null;
    }
}
