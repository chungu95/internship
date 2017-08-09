package project_management.repository.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class StockProjectPK implements Serializable {
    private int stockId;
    private int projId;

    @Column(name = "stock_id")
    @Id
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Column(name = "proj_id")
    @Id
    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockProjectPK that = (StockProjectPK) o;

        if (stockId != that.stockId) return false;
        if (projId != that.projId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId;
        result = 31 * result + projId;
        return result;
    }
}
