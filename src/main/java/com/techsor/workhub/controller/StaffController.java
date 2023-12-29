package com.techsor.workhub.controller;


import com.techsor.workhub.pojo.Staff;
import com.techsor.workhub.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    @CrossOrigin
    @GetMapping(value = "/staff")
    public ResponseEntity<List<Staff>> getStaffInfo(@RequestParam(required = false) String jobNumber,
                                                    @RequestParam(required = false) String staffName,
                                                    @RequestParam(required = false) String departmentName) {
        List<Staff> staffList;
        staffList = staffService.findWithConditions(jobNumber, staffName, departmentName).getBody();
        assert staffList != null;
        if (staffList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(staffList, HttpStatus.OK);
        }
    }
    @CrossOrigin
    @PostMapping("/updateStaff")
    @ResponseStatus(HttpStatus.OK)
    public Staff updateStaff(@RequestBody Staff staff) {
        Long staffId = (long) staff.getStaffId();
        String staffName = staff.getStaffName();
        Long departmentId = staff.getDepartmentId();
        Long positionId = staff.getPositionId();
        String workplace = staff.getWorkplace();

        return staffService.updateStaffInfo(staffId, staffName, departmentId, positionId, workplace).getBody();
    }
    @CrossOrigin
    @PostMapping("/addStaff")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus addStaff(@RequestBody Staff staff) {
        String jobNumber = staff.getJobNumber();
        String staffName = staff.getStaffName();
        Long departmentId = staff.getDepartmentId();
        Long positionId = staff.getPositionId();
        String workplace = staff.getWorkplace();

        return staffService.addStaff(jobNumber, staffName, departmentId, positionId, workplace);
    }

    @CrossOrigin
    @PostMapping("/deleteStaff")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deleteStaff(@RequestBody Staff staff) {
        long staffId = staff.getStaffId();

        return staffService.deleteStaff(staffId);
    }
}
