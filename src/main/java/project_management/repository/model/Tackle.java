package project_management.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tackle {
    private int tackleId;
    private String tckName;
    private Integer quantity;
    private List<TackleEmployee> tackleEmployeesByTackleId;

    @Id
    @Column(name = "tackle_id")
    public int getTackleId() {
        return tackleId;
    }

    public void setTackleId(int tackleId) {
        this.tackleId = tackleId;
    }

    @Basic
    @Column(name = "tck_name")
    public String getTckName() {
        return tckName;
    }

    public void setTckName(String tckName) {
        this.tckName = tckName;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tackle tackle = (Tackle) o;

        if (tackleId != tackle.tackleId) return false;
        if (tckName != null ? !tckName.equals(tackle.tckName) : tackle.tckName != null) return false;
        if (quantity != null ? !quantity.equals(tackle.quantity) : tackle.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tackleId;
        result = 31 * result + (tckName != null ? tckName.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tackleByTackleId")
    public List<TackleEmployee> getTackleEmployeesByTackleId() {
        return tackleEmployeesByTackleId;
    }

    public void setTackleEmployeesByTackleId(List<TackleEmployee> tackleEmployeesByTackleId) {
        this.tackleEmployeesByTackleId = tackleEmployeesByTackleId;
    }
}
