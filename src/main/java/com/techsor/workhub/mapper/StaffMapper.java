package com.techsor.workhub.mapper;

import com.techsor.workhub.entity.Staff;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StaffMapper {
    @Select("select * from staff")
    List<Staff> find();
}
