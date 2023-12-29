package com.techsor.workhub.service;

import com.techsor.workhub.pojo.Department;
import com.techsor.workhub.pojo.Positons;
import com.techsor.workhub.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartment();
    ResponseEntity<Department> updateDepart(@Param("departmentId") Long departmentId, @Param("departmentName") String departmentName);
    Department getDepartById(Long departmentId);
    int addDepart( @Param("departmentName") String departmentName);
    int deleteDepartById(Long departmentId);
}
