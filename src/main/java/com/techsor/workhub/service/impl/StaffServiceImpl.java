package com.techsor.workhub.service.impl;

import com.techsor.workhub.mapper.StaffMapper;
import com.techsor.workhub.pojo.Staff;
import com.techsor.workhub.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffMapper staffMapper;

    @Autowired
    public StaffServiceImpl(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

//    @Override
//    public ResponseEntity<List<Staff>> find() {
//        List<Staff> result = staffMapper.find();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @Override
    public ResponseEntity<List<Staff>> findWithConditions(String jobNumber, String staffName, String departmentName) {
        List<Staff> result = staffMapper.findWithConditions(jobNumber, staffName, departmentName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Staff> updateStaffInfo(String staffName, Long departmentId, Long positionId, String workplace) {
        return null;
    }

    @Override
    public Staff getStaffById(Long staffId) {
        return null;
    }

    @Override
    public ResponseEntity<Staff> updateStaffInfo(Long staffId, String staffName, Long departmentId, Long positionId, String workplace) {
        // 调用 Mapper 更新数据库
        int updatedRows = staffMapper.updateStaffInfo(staffId, staffName, departmentId, positionId, workplace);
        if (updatedRows > 0) {
            // 如果更新成功，返回更新后的数据和状态码 200 OK
            Staff updatedStaff = staffMapper.getStaffById(staffId); // 假设有一个方法可以根据 staffName 查询员工信息
            return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
        } else {
            // 如果更新失败，返回状态码 404 NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public HttpStatus addStaff(String jobNumber, String staffName, Long departmentId, Long positionId, String workplace) {
        // 假设 staffMapper.addStaff 返回一个表示成功的布尔值
        int addRows = staffMapper.addStaff(jobNumber, staffName, departmentId, positionId, workplace);
        // 如果更新成功，返回更新后的数据和状态码 200 OK
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus deleteStaff(long staffId) {
        int addRows = staffMapper.deleteStaffById(staffId);
        return HttpStatus.OK;
    }
}
