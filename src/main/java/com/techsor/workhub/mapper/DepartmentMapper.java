package com.techsor.workhub.mapper;

import com.techsor.workhub.pojo.Department;
import com.techsor.workhub.pojo.Positons;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM department")
    List<Department> getDepartment();

    @Update("UPDATE department SET departmentName = #{departmentName} WHERE departmentId = #{departmentId}")
    int updateDepart(@Param("departmentId") Long departmentId, @Param("departmentName") String departmentName);

    @Select("""
    SELECT * FROM department WHERE departmentId = #{departmentId}
""")
    Department getDepartById(Long departmentId);

    @Insert("INSERT INTO department (departmentName) VALUES (#{departmentName});")
    int addDepart( @Param("departmentName") String departmentName);
    @Delete("DELETE FROM department WHERE departmentId = #{departmentId}")
    int deleteDepartById(Long departmentId);
}
