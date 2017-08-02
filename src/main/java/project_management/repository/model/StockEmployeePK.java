package project_management.repository.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class StockEmployeePK implements Serializable {
    private int stockId;
    private int empId;

    @Column(name = "stock_id")
    @Id
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
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

        StockEmployeePK that = (StockEmployeePK) o;

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
}
