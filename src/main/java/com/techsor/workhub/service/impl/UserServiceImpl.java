package com.techsor.workhub.service.impl;

import com.techsor.workhub.mapper.PositionsMapper;
import com.techsor.workhub.mapper.UserMapper;
import com.techsor.workhub.pojo.Positons;
import com.techsor.workhub.service.PositionsService;
import com.techsor.workhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Integer userLogin(String username, String userpassword) {
        return userMapper.userLogin(username,userpassword);
    }

}
