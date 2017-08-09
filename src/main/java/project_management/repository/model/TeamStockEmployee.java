package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "TEAM_STOCK_EMPLOYEE")
public class TeamStockEmployee {
    private int id;
    private Integer stockId;
    private Float quantity;
    private String description;
    private TeamEmployeeJob teamEmployeeJobById;
    private Stock stockByStockId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stock_id")
    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
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

        TeamStockEmployee that = (TeamStockEmployee) o;

        if (id != that.id) return false;
        if (stockId != null ? !stockId.equals(that.stockId) : that.stockId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public TeamEmployeeJob getTeamEmployeeJobById() {
        return teamEmployeeJobById;
    }

    public void setTeamEmployeeJobById(TeamEmployeeJob teamEmployeeJobById) {
        this.teamEmployeeJobById = teamEmployeeJobById;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", referencedColumnName = "stock_id", insertable = false, updatable = false)
    public Stock getStockByStockId() {
        return stockByStockId;
    }

    public void setStockByStockId(Stock stockByStockId) {
        this.stockByStockId = stockByStockId;
    }
}
