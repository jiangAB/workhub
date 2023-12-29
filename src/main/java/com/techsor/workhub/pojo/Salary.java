package com.techsor.workhub.pojo;

public class Salary {
    private Long staffId;
    private String staffName;
    private String jobNumber;
    private Long departmentId;
    private Float fiveInsuranceOneFund;
    private Float basicSalary;
    private Float housingSubsidy;
    private Float mealSubsidy;
    private Float bonus;
    private Float commission;
    private Float grossSalary;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Float getFiveInsuranceOneFund() {
        return fiveInsuranceOneFund;
    }

    public void setFiveInsuranceOneFund(Float fiveInsuranceOneFund) {
        this.fiveInsuranceOneFund = fiveInsuranceOneFund;
    }

    public Float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Float getHousingSubsidy() {
        return housingSubsidy;
    }

    public void setHousingSubsidy(Float housingSubsidy) {
        this.housingSubsidy = housingSubsidy;
    }

    public Float getMealSubsidy() {
        return mealSubsidy;
    }

    public void setMealSubsidy(Float mealSubsidy) {
        this.mealSubsidy = mealSubsidy;
    }

    public Float getBonus() {
        return bonus;
    }

    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Float getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Float grossSalary) {
        this.grossSalary = grossSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", departmentId=" + departmentId +
                ", fiveInsuranceOneFund=" + fiveInsuranceOneFund +
                ", basicSalary=" + basicSalary +
                ", housingSubsidy=" + housingSubsidy +
                ", mealSubsidy=" + mealSubsidy +
                ", bonus=" + bonus +
                ", commission=" + commission +
                ", grossSalary=" + grossSalary +
                '}';
    }
}
