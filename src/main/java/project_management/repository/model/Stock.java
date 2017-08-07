package project_management.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stock {
    private int stockId;
    private String measurement;
    private Float quantity;
    private String stockName;
    private Float reserve;
    private List<StockProject> stockProjectsByStockId;
    private List<TeamStockEmployee> teamStockEmployeesByStockId;
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
    @Column(name = "measurement")
    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    @Basic
    @Column(name = "quantity")
    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
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
    @Column(name = "reserve")
    public Float getReserve() {
        return reserve;
    }

    public void setReserve(Float reserve) {
        this.reserve = reserve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (stockId != stock.stockId) return false;
        if (measurement != null ? !measurement.equals(stock.measurement) : stock.measurement != null) return false;
        if (quantity != null ? !quantity.equals(stock.quantity) : stock.quantity != null) return false;
        if (stockName != null ? !stockName.equals(stock.stockName) : stock.stockName != null) return false;
        if (reserve != null ? !reserve.equals(stock.reserve) : stock.reserve != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId;
        result = 31 * result + (measurement != null ? measurement.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (reserve != null ? reserve.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stockByStockId", fetch = FetchType.LAZY)
    public List<StockProject> getStockProjectsByStockId() {
        return stockProjectsByStockId;
    }

    public void setStockProjectsByStockId(List<StockProject> stockProjectsByStockId) {
        this.stockProjectsByStockId = stockProjectsByStockId;
    }

    @OneToMany(mappedBy = "stockByStockId", fetch = FetchType.LAZY)
    public List<TeamStockEmployee> getTeamStockEmployeesByStockId() {
        return teamStockEmployeesByStockId;
    }

    public void setTeamStockEmployeesByStockId(List<TeamStockEmployee> teamStockEmployeesByStockId) {
        this.teamStockEmployeesByStockId = teamStockEmployeesByStockId;
    }

    @OneToMany(mappedBy = "stockByStockId", fetch = FetchType.LAZY)
    public List<StockEmployee> getStockEmployeesByStockId() {
        return stockEmployeesByStockId;
    }

    public void setStockEmployeesByStockId(List<StockEmployee> stockEmployeesByStockId) {
        this.stockEmployeesByStockId = stockEmployeesByStockId;
    }
}
