package project_management.repository.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
                             @UniqueConstraint(columnNames = "email")})
public class Users implements Serializable{
    private int userId;
    private String password;
    private String userType;
    private String username;
    private String userEmail;
    private List<UsersPermission> usersPermissionsByUserId;
    private Employee employeesByUserId;

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "email", unique = true)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (userType != null ? !userType.equals(users.userType) : users.userType != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserId", fetch = FetchType.LAZY)
    public List<UsersPermission> getUsersPermissionsByUserId() {
        return usersPermissionsByUserId;
    }

    public void setUsersPermissionsByUserId(List<UsersPermission> usersPermissionsByUserId) {
        this.usersPermissionsByUserId = usersPermissionsByUserId;
    }

    @OneToOne(mappedBy = "usersByUserId", fetch = FetchType.LAZY)
    public Employee getEmployeesByUserId() {
        return employeesByUserId;
    }

    public void setEmployeesByUserId(Employee employeesByUserId) {
        this.employeesByUserId = employeesByUserId;
    }
}
