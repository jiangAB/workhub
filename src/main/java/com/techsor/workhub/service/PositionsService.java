package com.techsor.workhub.service;

import com.techsor.workhub.pojo.Department;
import com.techsor.workhub.pojo.Positons;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PositionsService {
    List<Positons> getPositions();
    ResponseEntity<Positons> updatePosition(@Param("positionId") Long positionId, @Param("positionName") String positionName);
    Positons getPositionById(Long positionId);
    int addPosition( @Param("positionName") String positionName);
    int deletePositionById(Long positionId);

}
