package com.techsor.workhub.controller;

import com.techsor.workhub.pojo.Department;
import com.techsor.workhub.pojo.Positons;
import com.techsor.workhub.pojo.Staff;
import com.techsor.workhub.service.DepartmentService;
import com.techsor.workhub.service.PositionsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionsController {
    private final PositionsService positionsService;

    public PositionsController(PositionsService positionsService) {
        this.positionsService = positionsService;
    }

    @CrossOrigin
    @GetMapping("/positions")
    public ResponseEntity<List<Positons>> getPositions() {
       List<Positons> positionsList;
       positionsList = positionsService.getPositions();
        if (positionsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(positionsList, HttpStatus.OK);
        }
    }
    @CrossOrigin
    @PostMapping("/updatePosition")
    public Positons updatePosition(@RequestBody Positons positons) {
        Long positionId = (long) positons.getPositionId();
        String positionName = positons.getPositionName();
        return positionsService.updatePosition(positionId,positionName).getBody();
    }
    @CrossOrigin
    @PostMapping("/addPosition")
    @ResponseStatus(HttpStatus.OK)
    public int addPosition(@RequestBody Positons positons) {
        String positionName = positons.getPositionName();

        return positionsService.addPosition(positionName);
    }
    @CrossOrigin
    @PostMapping("/deletePosition")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deletePosition(@RequestBody Positons positions) {
        try {
            long positionId = positions.getPositionId();
            int deletedCount = positionsService.deletePositionById(positionId);
            if (deletedCount > 0) {
                return ResponseEntity.ok("Position deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Position not found");
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("与员工关联,请先解除关联");
        }
    }
}
