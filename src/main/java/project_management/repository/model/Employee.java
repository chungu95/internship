package project_management.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
public class Employee implements Serializable {
    private int empId;
    private String epAddress;
    private Date epDayofbirth;
    private String epEmail;
    private String epName;
    private String epPhoneNumber;
    private Integer userId;
    private String epCmt;
    private Users usersByUserId;
    private Integer isDeleted;
    private String status = "FREE";
    private List<StockEmployee> stockEmployeesByEmpId;
    private List<TackleEmployee> tackleEmployeesByEmpId;
    private List<TeamEmployeeJob> teamEmployeeJobsByEmpId;

    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "ep_address")
    public String getEpAddress() {
        return epAddress;
    }

    public void setEpAddress(String epAddress) {
        this.epAddress = epAddress;
    }

    @Basic
    @Column(name = "ep_dayofbirth")
    public Date getEpDayofbirth() {
        return epDayofbirth;
    }

    public void setEpDayofbirth(Date epDayofbirth) {
        this.epDayofbirth = epDayofbirth;
    }

    @Basic
    @Column(name = "ep_email")
    public String getEpEmail() {
        return epEmail;
    }

    public void setEpEmail(String epEmail) {
        this.epEmail = epEmail;
    }

    @Basic
    @Column(name = "ep_name")
    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName;
    }

    @Basic
    @Column(name = "ep_phone_number")
    public String getEpPhoneNumber() {
        return epPhoneNumber;
    }

    public void setEpPhoneNumber(String epPhoneNumber) {
        this.epPhoneNumber = epPhoneNumber;
    }

    @Basic
    @Column(name = "ep_cmt", unique = true, nullable = true)
    public String getEpCmt() {
        return epCmt;
    }

    public void setEpCmt(String epCmt) {
        this.epCmt = epCmt;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "is_deleted", nullable = false, columnDefinition = "int default 0")
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Transient
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (empId != employee.empId) return false;
        if (epAddress != null ? !epAddress.equals(employee.epAddress) : employee.epAddress != null) return false;
        if (epDayofbirth != null ? !epDayofbirth.equals(employee.epDayofbirth) : employee.epDayofbirth != null)
            return false;
        if (epEmail != null ? !epEmail.equals(employee.epEmail) : employee.epEmail != null) return false;
        if (epName != null ? !epName.equals(employee.epName) : employee.epName != null) return false;
        if (epPhoneNumber != null ? !epPhoneNumber.equals(employee.epPhoneNumber) : employee.epPhoneNumber != null)
            return false;
        if (userId != null ? !userId.equals(employee.userId) : employee.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empId;
        result = 31 * result + (epAddress != null ? epAddress.hashCode() : 0);
        result = 31 * result + (epDayofbirth != null ? epDayofbirth.hashCode() : 0);
        result = 31 * result + (epEmail != null ? epEmail.hashCode() : 0);
        result = 31 * result + (epName != null ? epName.hashCode() : 0);
        result = 31 * result + (epPhoneNumber != null ? epPhoneNumber.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @OneToMany(mappedBy = "employeeByEmpId", fetch = FetchType.LAZY)
    public List<StockEmployee> getStockEmployeesByEmpId() {
        return stockEmployeesByEmpId;
    }

    public void setStockEmployeesByEmpId(List<StockEmployee> stockEmployeesByEmpId) {
        this.stockEmployeesByEmpId = stockEmployeesByEmpId;
    }

    @OneToMany(mappedBy = "employeeByEmpId", fetch = FetchType.LAZY)
    public List<TackleEmployee> getTackleEmployeesByEmpId() {
        return tackleEmployeesByEmpId;
    }

    public void setTackleEmployeesByEmpId(List<TackleEmployee> tackleEmployeesByEmpId) {
        this.tackleEmployeesByEmpId = tackleEmployeesByEmpId;
    }

    @OneToMany(mappedBy = "employeeByEpId", fetch = FetchType.LAZY)
    public List<TeamEmployeeJob> getTeamEmployeeJobsByEmpId() {
        return teamEmployeeJobsByEmpId;
    }

    public void setTeamEmployeeJobsByEmpId(List<TeamEmployeeJob> teamEmployeeJobsByEmpId) {
        this.teamEmployeeJobsByEmpId = teamEmployeeJobsByEmpId;
    }
}
