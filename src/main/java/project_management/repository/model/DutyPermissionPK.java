package project_management.repository.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DutyPermissionPK implements Serializable {
    private int permissionId;
    private int dutyId;

    @Column(name = "permission_id")
    @Id
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Column(name = "duty_id")
    @Id
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

        DutyPermissionPK that = (DutyPermissionPK) o;

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
}
