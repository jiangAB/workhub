package com.techsor.workhub.service.impl;

import com.techsor.workhub.mapper.DepartmentMapper;
import com.techsor.workhub.pojo.Department;
import com.techsor.workhub.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> getDepartment() {
        return departmentMapper.getDepartment();
    }

    @Override
    public Department getDepartById(Long departmentId) {
        return null;
    }
    @Override
    public ResponseEntity<Department> updateDepart(Long departmentId, String departmentName) {
        // 调用 Mapper 更新数据库
        int updatedRows = departmentMapper.updateDepart(departmentId, departmentName);
        if (updatedRows > 0) {
            // 如果更新成功，返回更新后的数据和状态码 200 OK
            Department updatedDepart = departmentMapper.getDepartById(departmentId); // 假设有一个方法可以根据 staffName 查询员工信息
            return new ResponseEntity<>(updatedDepart, HttpStatus.OK);
        } else {
            // 如果更新失败，返回状态码 404 NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public int addDepart(String departmentName) {
        // 假设 staffMapper.addStaff 返回一个表示成功的布尔值
        // 如果更新成功，返回更新后的数据和状态码 200 OK
        return departmentMapper.addDepart(departmentName);
    }
    @Override
    public int deleteDepartById(Long departmentId) {
        return departmentMapper.deleteDepartById(departmentId);
    }
}
