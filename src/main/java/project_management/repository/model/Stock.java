package project_management.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stock {
    private int stockId;
    private String stockName;
    private Integer quantity;
    private String measurement;
    private List<StockEmployee> stockEmployeesByStockId;

    @Id
    @Column(name = "stock_id")
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "stock_name")
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "measurement")
    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (stockId != stock.stockId) return false;
        if (stockName != null ? !stockName.equals(stock.stockName) : stock.stockName != null) return false;
        if (quantity != null ? !quantity.equals(stock.quantity) : stock.quantity != null) return false;
        if (measurement != null ? !measurement.equals(stock.measurement) : stock.measurement != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (measurement != null ? measurement.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stockByStockId")
    public List<StockEmployee> getStockEmployeesByStockId() {
        return stockEmployeesByStockId;
    }

    public void setStockEmployeesByStockId(List<StockEmployee> stockEmployeesByStockId) {
        this.stockEmployeesByStockId = stockEmployeesByStockId;
    }
}
