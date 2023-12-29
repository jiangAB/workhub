package com.techsor.workhub.pojo;

public class Staff {
    private int staffId;
    private String jobNumber;
    private String staffName;
    private String departmentName;
    private long departmentId;
    private String positionName;
    private long positionId;

    private String workplace;

    private Float grossSalary;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Float getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Float grossSalary) {
        this.grossSalary = grossSalary;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", jobNumber='" + jobNumber + '\'' +
                ", staffName='" + staffName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentId=" + departmentId +
                ", positionName='" + positionName + '\'' +
                ", positionId=" + positionId +
                ", workplace='" + workplace + '\'' +
                ", grossSalary=" + grossSalary +
                '}';
    }
}
