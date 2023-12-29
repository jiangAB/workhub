package com.techsor.workhub.mapper;

import com.techsor.workhub.pojo.Staff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface StaffMapper {
    @SelectProvider(type = StaffSqlProvider.class, method = "findWithConditions")
    public List<Staff> findWithConditions(@Param("jobNumber") String jobNumber,
                                          @Param("staffName") String staffName,
                                          @Param("departmentName") String departmentName);

    class StaffSqlProvider {
        public String findWithConditions(@Param("jobNumber") String jobNumber,
                                         @Param("staffName") String staffName,
                                         @Param("departmentName") String departmentName) {
            return new SQL() {{
                SELECT("s.staffId, s.jobNumber, s.staffName, s.departmentId, d.departmentName, s.positionId, p.positionName, s.workplace, salary.grossSalary");
                FROM("staff s");
                JOIN("department d ON s.departmentId = d.departmentId");
                JOIN("positions p ON s.positionId = p.positionId");
                JOIN("salary ON s.staffId = salary.staffId");
                if (jobNumber != null && !jobNumber.isEmpty()) {
                    WHERE("s.jobNumber = #{jobNumber}");
                }
                if (staffName != null && !staffName.isEmpty()) {
                    WHERE("s.staffName = #{staffName}");
                }
                if (departmentName != null && !departmentName.isEmpty()) {
                    WHERE("d.departmentName = #{departmentName}");
                }
                ORDER_BY("s.staffId ASC");
            }}.toString();
        }
    }
    @Update("UPDATE staff SET staffName = #{staffName}, departmentId = #{departmentId}, positionId = #{positionId}, workplace = #{workplace} WHERE staffId = #{staffId}")
    int updateStaffInfo(@Param("staffId") Long staffId,@Param("staffName") String staffName, @Param("departmentId") Long departmentId, @Param("positionId") Long positionId, @Param("workplace") String workplace);
    @Select("""
    SELECT s.staffId, s.jobNumber, s.staffName, s.departmentId, d.departmentName, s.positionId, p.positionName, s.workplace, salary.grossSalary
    FROM staff s
    JOIN department d ON s.departmentId = d.departmentId
    JOIN positions p ON s.positionId = p.positionId
    JOIN salary ON s.staffId = salary.staffId
    WHERE s.staffId = #{staffId}
""")
    Staff getStaffById(Long staffId);

    @Insert("INSERT INTO staff (jobNumber, staffName, departmentId, positionId, workplace) VALUES (#{jobNumber}, #{staffName}, #{departmentId}, #{positionId}, #{workplace});")
    int addStaff( @Param("jobNumber") String jobNumber, @Param("staffName") String staffName, @Param("departmentId") Long departmentId, @Param("positionId") Long positionId, @Param("workplace") String workplace);

    @Delete("DELETE FROM staff WHERE staffId = #{staffId}")
    int deleteStaffById(Long staffId);
}
