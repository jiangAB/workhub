package com.techsor.workhub.mapper;

import com.techsor.workhub.pojo.Positons;
import com.techsor.workhub.pojo.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PositionsMapper {
    @Select("SELECT * FROM positions")
    List<Positons> getPositions();

    @Update("UPDATE positions SET positionName = #{positionName} WHERE positionId = #{positionId}")
    int updatePosition(@Param("positionId") Long positionId, @Param("positionName") String positionName);
    @Select("""
    SELECT * FROM positions WHERE positionId = #{positionId}
""")
    Positons getPositionById(Long positionId);
    @Insert("INSERT INTO positions (positionName) VALUES (#{positionName});")
    int addPosition( @Param("positionName") String positionName);
    @Delete("DELETE FROM positions WHERE positionId = #{positionId}")
    int deletePositionById(Long positionId);
}
