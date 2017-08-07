package project_management.repository.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UsersPermissionPK implements Serializable {
    private int userId;
    private int permissionId;

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "permission_id")
    @Id
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

        UsersPermissionPK that = (UsersPermissionPK) o;

        if (userId != that.userId) return false;
        if (permissionId != that.permissionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + permissionId;
        return result;
    }
}
