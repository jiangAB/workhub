package com.techsor.workhub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
        @GetMapping(value = "/staff")
        public String getStaffInfo() {
            return "数据库查询";
        }
}
