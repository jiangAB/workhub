package com.techsor.workhub.service;

import com.techsor.workhub.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StaffService {
//    List<Staff> find(); // 不带条件的查询方法

    ResponseEntity<List<Staff>> findWithConditions(String jobNumber, String staffName, String departmentName); // 带条件的查询方法
    ResponseEntity<Staff> updateStaffInfo(String staffName, Long departmentId, Long positionId, String workplace);
    Staff getStaffById(Long staffId);

    ResponseEntity<Staff> updateStaffInfo(Long staffId, String staffName, Long departmentId, Long positionId, String workplace);
    HttpStatus addStaff(@Param("jobNumber") String jobNumber, @Param("staffName") String staffName, @Param("departmentId") Long departmentId, @Param("positionId") Long positionId, @Param("workplace") String workplace);

    HttpStatus deleteStaff(long staffId);
}
