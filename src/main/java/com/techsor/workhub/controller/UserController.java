package com.techsor.workhub.controller;

import com.techsor.workhub.pojo.Positons;
import com.techsor.workhub.pojo.User;
import com.techsor.workhub.service.PositionsService;
import com.techsor.workhub.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/userLogin")
    public Integer userLogin(@RequestBody User user) {
       String username = user.getUsername();
       String userpassword = user.getUserpassword();
        return userService.userLogin(username, userpassword);
    }
}
