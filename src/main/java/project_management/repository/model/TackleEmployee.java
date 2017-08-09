package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "tackle_employee")
@IdClass(TackleEmployeePK.class)
public class TackleEmployee {
    private int tackleId;
    private int empId;
    private Tackle tackleByTackleId;
    private Employee employeeByEmpId;

    @Id
    @Column(name = "tackle_id")
    public int getTackleId() {
        return tackleId;
    }

    public void setTackleId(int tackleId) {
        this.tackleId = tackleId;
    }

    @Id
    @Column(name = "emp_id")
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

        TackleEmployee that = (TackleEmployee) o;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tackle_id", referencedColumnName = "tackle_id", nullable = false, insertable = false, updatable = false)
    public Tackle getTackleByTackleId() {
        return tackleByTackleId;
    }

    public void setTackleByTackleId(Tackle tackleByTackleId) {
        this.tackleByTackleId = tackleByTackleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id", nullable = false, insertable = false, updatable = false)
    public Employee getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(Employee employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }
}
