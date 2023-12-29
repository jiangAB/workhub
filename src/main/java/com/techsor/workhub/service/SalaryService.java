package com.techsor.workhub.service;

import com.techsor.workhub.pojo.Salary;
import com.techsor.workhub.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SalaryService {

    ResponseEntity<List<Salary>> findSalary(String jobNumber, String staffName,Long departmentId, Long staffId);
    ResponseEntity<Salary> updateSalaryInfo(@Param("staffId") Long staffId,@Param("fiveInsuranceOneFund") Float fiveInsuranceOneFund, @Param("basicSalary") Float basicSalary, @Param("housingSubsidy") Float housingSubsidy, @Param("mealSubsidy") Float mealSubsidy, @Param("bonus") Float bonus, @Param("commission") Float commission);
}
