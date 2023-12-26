package com.techsor.workhub.controller;


import com.techsor.workhub.pojo.Staff;
import com.techsor.workhub.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;
    @GetMapping(value = "/staff")
    public List<Staff> getStaffInfo() {
            return staffService.find();
        }
}
