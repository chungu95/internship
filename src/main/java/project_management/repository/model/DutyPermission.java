package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "DUTY_PERMISSION")
@IdClass(DutyPermissionPK.class)
public class DutyPermission {
    private int dutyId;
    private int permissionId;
    private Duty dutyByDutyId;
    private Permission permissionByPermissionId;

    @Id
    @Column(name = "duty_id")
    public int getDutyId() {
        return dutyId;
    }

    public void setDutyId(int dutyId) {
        this.dutyId = dutyId;
    }

    @Id
    @Column(name = "permission_id")
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DutyPermission that = (DutyPermission) o;

        if (dutyId != that.dutyId) return false;
        if (permissionId != that.permissionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dutyId;
        result = 31 * result + permissionId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "duty_id", referencedColumnName = "duty_id", nullable = false, insertable = false, updatable = false)
    public Duty getDutyByDutyId() {
        return dutyByDutyId;
    }

    public void setDutyByDutyId(Duty dutyByDutyId) {
        this.dutyByDutyId = dutyByDutyId;
    }

    @ManyToOne
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id", nullable = false, insertable = false, updatable = false)
    public Permission getPermissionByPermissionId() {
        return permissionByPermissionId;
    }

    public void setPermissionByPermissionId(Permission permissionByPermissionId) {
        this.permissionByPermissionId = permissionByPermissionId;
    }
}
