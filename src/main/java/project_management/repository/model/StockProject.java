package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "STOCK_PROJECT")
@IdClass(StockProjectPK.class)
public class StockProject {
    private int stockId;
    private int projId;
    private Float quantity;
    private String description;
    private Stock stockByStockId;
    private Project projectByProjId;

    @Id
    @Column(name = "stock_id")
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Id
    @Column(name = "proj_id")
    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockProject that = (StockProject) o;

        if (stockId != that.stockId) return false;
        if (projId != that.projId) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId;
        result = 31 * result + projId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
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
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id", nullable = false, insertable = false, updatable = false)
    public Project getProjectByProjId() {
        return projectByProjId;
    }

    public void setProjectByProjId(Project projectByProjId) {
        this.projectByProjId = projectByProjId;
    }
}
