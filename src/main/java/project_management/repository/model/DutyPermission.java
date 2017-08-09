package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "duty_permission")
@IdClass(DutyPermissionPK.class)
public class DutyPermission {
    private int permissionId;
    private int dutyId;
    private Permission permissionByPermissionId;
    private Duty dutyByDutyId;

    @Id
    @Column(name = "permission_id")
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Id
    @Column(name = "duty_id")
    public int getDutyId() {
        return dutyId;
    }

    public void setDutyId(int dutyId) {
        this.dutyId = dutyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DutyPermission that = (DutyPermission) o;

        if (permissionId != that.permissionId) return false;
        if (dutyId != that.dutyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionId;
        result = 31 * result + dutyId;
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id", nullable = false, insertable = false, updatable = false)
    public Permission getPermissionByPermissionId() {
        return permissionByPermissionId;
    }

    public void setPermissionByPermissionId(Permission permissionByPermissionId) {
        this.permissionByPermissionId = permissionByPermissionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duty_id", referencedColumnName = "duty_id", nullable = false, insertable = false, updatable = false)
    public Duty getDutyByDutyId() {
        return dutyByDutyId;
    }

    public void setDutyByDutyId(Duty dutyByDutyId) {
        this.dutyByDutyId = dutyByDutyId;
    }
}
