package com.techsor.workhub.service.impl;

import com.techsor.workhub.mapper.PositionsMapper;
import com.techsor.workhub.pojo.Positons;
import com.techsor.workhub.service.PositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionsServiceImpl implements PositionsService {
    private final PositionsMapper positionsMapper;

    @Autowired
    public PositionsServiceImpl(PositionsMapper positionsMapper) {
        this.positionsMapper = positionsMapper;
    }

    @Override
    public List<Positons> getPositions() {
        return positionsMapper.getPositions();
    }

    @Override
    public Positons getPositionById(Long positionId) {
        return null;
    }
    @Override
    public ResponseEntity<Positons> updatePosition(Long positionId, String positionName) {
        // 调用 Mapper 更新数据库
        int updatedRows = positionsMapper.updatePosition(positionId, positionName);
        if (updatedRows > 0) {
            // 如果更新成功，返回更新后的数据和状态码 200 OK
            Positons updatedPosition = positionsMapper.getPositionById(positionId); // 假设有一个方法可以根据 staffName 查询员工信息
            return new ResponseEntity<>(updatedPosition, HttpStatus.OK);
        } else {
            // 如果更新失败，返回状态码 404 NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public int addPosition(String positionName) {
        // 假设 staffMapper.addStaff 返回一个表示成功的布尔值
        // 如果更新成功，返回更新后的数据和状态码 200 OK
        return positionsMapper.addPosition(positionName);
    }
    @Override
    public int deletePositionById(Long positionId) {
        return positionsMapper.deletePositionById(positionId);
    }
}
