package com.techsor.workhub.service;

import com.techsor.workhub.pojo.Positons;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    Integer userLogin(String username, String userpassword );

}
