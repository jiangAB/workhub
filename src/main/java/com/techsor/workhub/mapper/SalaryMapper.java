package com.techsor.workhub.mapper;

import com.techsor.workhub.pojo.Salary;
import com.techsor.workhub.pojo.Staff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

@Mapper
public interface SalaryMapper {
    @SelectProvider(type = SalaryMapperProvider.class, method = "findSalary")
    List<Salary> findSalary(@Param("jobNumber") String jobNumber,
                            @Param("staffName") String staffName,
                            @Param("departmentId") Long departmentId,
                            @Param("staffId") Long staffId);

    public class SalaryMapperProvider {
        public String findSalary(@Param("jobNumber") String jobNumber,
                                 @Param("staffName") String staffName,
                                 @Param("departmentId") Long departmentId,
                                 @Param("staffId") Long staffId) {
            return new SQL() {{
                SELECT("st.staffId, st.staffName,st.jobNumber, st.departmentId, s.*");
                FROM("salary s");
                JOIN("staff st ON s.staffId = st.staffId");
                if (jobNumber != null && !jobNumber.isEmpty()) {
                    WHERE("st.jobNumber = #{jobNumber}");
                }
                if (staffName != null && !staffName.isEmpty()) {
                    WHERE("st.staffName = #{staffName}");
                }
                if (departmentId != null) {
                    WHERE("st.departmentId = #{departmentId}");
                }
                if (staffId != null) {
                    WHERE("st.staffId = #{staffId}");
                }
            }}.toString();
        }
    }
    @SelectProvider(type = SalaryMapperProviderById.class, method = "findSalaryById")
    Salary findSalaryById(@Param("staffId") Long staffId);

    public class SalaryMapperProviderById {
        public String findSalaryById(@Param("staffId") Long staffId) {
            return new SQL() {{
                SELECT("st.staffId, st.staffName,st.jobNumber, st.departmentId, s.*");
                FROM("salary s");
                JOIN("staff st ON s.staffId = st.staffId");
                if (staffId != null) {
                    WHERE("st.staffId = #{staffId}");
                }
            }}.toString();
        }
    }

    @Update("UPDATE salary SET fiveInsuranceOneFund = #{fiveInsuranceOneFund}, basicSalary = #{basicSalary}, housingSubsidy = #{housingSubsidy}, mealSubsidy = #{mealSubsidy}, bonus = #{bonus},commission = #{commission}, grossSalary = ${ basicSalary + housingSubsidy + mealSubsidy + bonus + commission - fiveInsuranceOneFund} WHERE staffId = #{staffId}")
    int updateSalaryInfo(@Param("staffId") Long staffId,@Param("fiveInsuranceOneFund") Float fiveInsuranceOneFund, @Param("basicSalary") Float basicSalary, @Param("housingSubsidy") Float housingSubsidy, @Param("mealSubsidy") Float mealSubsidy, @Param("bonus") Float bonus, @Param("commission") Float commission);
}
