package com.techsor.workhub.service.impl;

import com.techsor.workhub.mapper.StaffMapper;
import com.techsor.workhub.pojo.Staff;
import com.techsor.workhub.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;
    @Override
    public List<Staff> find() {
        return staffMapper.find();
    }
}
