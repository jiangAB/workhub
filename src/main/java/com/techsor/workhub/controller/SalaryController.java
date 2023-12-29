package com.techsor.workhub.controller;


import com.techsor.workhub.pojo.Salary;
import com.techsor.workhub.service.SalaryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {
    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }
//    @CrossOrigin
//    @GetMapping(value = "/salaryccc")
//    public int ASD() {
//        return 1;
//    }
    @CrossOrigin
    @GetMapping(value = "/salary")
    public ResponseEntity<List<Salary>> getSalaryInfo(@RequestParam(required = false) String jobNumber,
                                                     @RequestParam(required = false) String staffName,
                                                     @RequestParam(required = false) Long departmentId,
                                                      @RequestParam(required = false) Long staffId) {
        List<Salary> salaryList;
        salaryList = salaryService.findSalary(jobNumber, staffName, departmentId, staffId).getBody();
        assert salaryList != null;
        return new ResponseEntity<>(salaryList, HttpStatus.OK);
//        if (salaryList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(salaryList, HttpStatus.OK);
//        }
    }
    @CrossOrigin
    @PostMapping("/upDateSalary")
    public Salary updateSalaryInfo( @RequestBody Salary salary
//           @Param("staffId") Long staffId,
//           @Param("fiveInsuranceOneFund") Float fiveInsuranceOneFund,
//           @Param("basicSalary") Float basicSalary,
//           @Param("housingSubsidy")  Float housingSubsidy,
//           @Param("mealSubsidy")  Float mealSubsidy,
//           @Param("bonus") Float bonus,
//           @Param("commission")  Float commission
    ) {
        Long staffId = salary.getStaffId();
        Float fiveInsuranceOneFund = salary.getFiveInsuranceOneFund();
        Float basicSalary = salary.getBasicSalary();
        Float housingSubsidy = salary.getHousingSubsidy();
        Float mealSubsidy = salary.getMealSubsidy();
        Float bonus = salary.getBonus();
        Float commission = salary.getCommission();
        return salaryService.updateSalaryInfo(staffId,fiveInsuranceOneFund,basicSalary,housingSubsidy,mealSubsidy,bonus,commission).getBody();
    }
}
