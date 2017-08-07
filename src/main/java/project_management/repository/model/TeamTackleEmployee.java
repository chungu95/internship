package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "TEAM_TACKLE_EMPLOYEE")
public class TeamTackleEmployee {
    private int id;
    private Integer tackleId;
    private Integer quantity;
    private String description;
    private TeamEmployeeJob teamEmployeeJobById;
    private Tackle tackleByTackleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tackle_id")
    public Integer getTackleId() {
        return tackleId;
    }

    public void setTackleId(Integer tackleId) {
        this.tackleId = tackleId;
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

        TeamTackleEmployee that = (TeamTackleEmployee) o;

        if (id != that.id) return false;
        if (tackleId != null ? !tackleId.equals(that.tackleId) : that.tackleId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tackleId != null ? tackleId.hashCode() : 0);
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
    @JoinColumn(name = "tackle_id", referencedColumnName = "tackle_id", insertable = false, updatable = false)
    public Tackle getTackleByTackleId() {
        return tackleByTackleId;
    }

    public void setTackleByTackleId(Tackle tackleByTackleId) {
        this.tackleByTackleId = tackleByTackleId;
    }
}
