package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "stock_employee")
@IdClass(StockEmployeePK.class)
public class StockEmployee {
    private int stockId;
    private int empId;
    private Stock stockByStockId;
    private Employee employeeByEmpId;

    @Id
    @Column(name = "stock_id")
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
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

        StockEmployee that = (StockEmployee) o;

        if (stockId != that.stockId) return false;
        if (empId != that.empId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId;
        result = 31 * result + empId;
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", referencedColumnName = "stock_id", nullable = false, insertable = false, updatable = false)
    public Stock getStockByStockId() {
        return stockByStockId;
    }

    public void setStockByStockId(Stock stockByStockId) {
        this.stockByStockId = stockByStockId;
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
