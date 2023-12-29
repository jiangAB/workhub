package com.techsor.workhub.controller;

import com.techsor.workhub.pojo.Department;
import com.techsor.workhub.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @CrossOrigin
    @GetMapping("/department")
    public ResponseEntity<List<Department>> getDepartment() {
       List<Department> departList;
       departList = departmentService.getDepartment();
        if (departList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(departList, HttpStatus.OK);
        }
    }
    @CrossOrigin
    @PostMapping("/updateDepartment")
    public Department updatePosition(@RequestBody Department department) {
        Long departmentId = (long) department.getDepartmentId();
        String departmentName = department.getDepartmentName();
        return departmentService.updateDepart(departmentId,departmentName).getBody();
    }

    @CrossOrigin
    @PostMapping("/addDepart")
    @ResponseStatus(HttpStatus.OK)
    public int addDepart(@RequestBody Department department) {
        String departmentName = department.getDepartmentName();

        return departmentService.addDepart(departmentName);
    }
    @CrossOrigin
    @PostMapping("/deleteDepart")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteDepart(@RequestBody Department department) {
        try {
            long departmentId = department.getDepartmentId();
            int deletedCount = departmentService.deleteDepartById(departmentId);
            if (deletedCount > 0) {
                return ResponseEntity.ok("Department deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("与员工关联,请先解除关联");
        }
    }
}
