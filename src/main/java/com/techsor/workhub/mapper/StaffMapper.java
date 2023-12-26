package com.techsor.workhub.mapper;

import com.techsor.workhub.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffMapper {
    @Select("SELECT id,staffName from staff")
    public List<Staff> find();
}
