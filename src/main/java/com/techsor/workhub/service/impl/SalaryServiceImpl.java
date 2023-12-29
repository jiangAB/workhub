package com.techsor.workhub.service.impl;

import com.techsor.workhub.mapper.SalaryMapper;
import com.techsor.workhub.mapper.StaffMapper;
import com.techsor.workhub.pojo.Salary;
import com.techsor.workhub.pojo.Staff;
import com.techsor.workhub.service.SalaryService;
import com.techsor.workhub.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    private final SalaryMapper salaryMapper;

    @Autowired
    public SalaryServiceImpl(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }

//    @Override
//    public ResponseEntity<List<Staff>> find() {
//        List<Staff> result = staffMapper.find();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @Override
    public ResponseEntity<List<Salary>> findSalary(String jobNumber, String staffName, Long departmentId, Long staffId) {
        List<Salary> result = salaryMapper.findSalary(jobNumber, staffName, departmentId, staffId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Salary> updateSalaryInfo(@Param("staffId") Long staffId,@Param("fiveInsuranceOneFund") Float fiveInsuranceOneFund, @Param("basicSalary") Float basicSalary, @Param("housingSubsidy") Float housingSubsidy, @Param("mealSubsidy") Float mealSubsidy, @Param("bonus") Float bonus, @Param("commission") Float commission) {
        int updatedRows = salaryMapper.updateSalaryInfo(staffId, fiveInsuranceOneFund, basicSalary, housingSubsidy, mealSubsidy, bonus, commission );
        if (updatedRows > 0) {
            // 如果更新成功，返回更新后的数据和状态码 200 OK
            Salary updatedSalary = salaryMapper.findSalaryById(staffId); // 假设有一个方法可以根据 staffName 查询员工信息
            return new ResponseEntity<>(updatedSalary, HttpStatus.OK);
        } else {
            // 如果更新失败，返回状态码 404 NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
