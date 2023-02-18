package com.tiker.service.impl;

import com.tiker.dao.UserMapper;
import com.tiker.entity.User;
import com.tiker.entity.vo.CreateUserVO;
import com.tiker.service.UserService;
import com.tiker.util.IDGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int userRegister(CreateUserVO createUserVO) {
        String userId = IDGenerator.generateUUID(32);
        User user = new User();
        user.setId(userId);
        user.setPhoneNumber(createUserVO.getPhoneNumber());
        user.setNickname(createUserVO.getNickname());
        user.setPassword(createUserVO.getPassword());
        user.setCollege(createUserVO.getCollege());

        return userMapper.insertUser(user);
    }

    @Override
    public String userLogin() {
        return null;
    }
}
