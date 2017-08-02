package project_management.repository.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TackleEmployeePK implements Serializable {
    private int tackleId;
    private int empId;

    @Column(name = "tackle_id")
    @Id
    public int getTackleId() {
        return tackleId;
    }

    public void setTackleId(int tackleId) {
        this.tackleId = tackleId;
    }

    @Column(name = "emp_id")
    @Id
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TackleEmployeePK that = (TackleEmployeePK) o;

        if (tackleId != that.tackleId) return false;
        if (empId != that.empId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tackleId;
        result = 31 * result + empId;
        return result;
    }
}
