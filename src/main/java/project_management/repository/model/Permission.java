package project_management.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Permission {
    private int permissionId;
    private String permissionName;
    private List<DutyPermission> dutyPermissionsByPermissionId;

    @Id
    @Column(name = "permission_id")
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "permission_name")
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (permissionId != that.permissionId) return false;
        if (permissionName != null ? !permissionName.equals(that.permissionName) : that.permissionName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionId;
        result = 31 * result + (permissionName != null ? permissionName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "permissionByPermissionId")
    public List<DutyPermission> getDutyPermissionsByPermissionId() {
        return dutyPermissionsByPermissionId;
    }

    public void setDutyPermissionsByPermissionId(List<DutyPermission> dutyPermissionsByPermissionId) {
        this.dutyPermissionsByPermissionId = dutyPermissionsByPermissionId;
    }
}
