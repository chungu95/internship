package project_management.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Duty {
    private int dutyId;
    private String dutyName;
    private List<DutyPermission> dutyPermissionsByDutyId;
    private List<TeamEmployeeJob> teamEmployeeJobsByDutyId;

    @Id
    @Column(name = "duty_id")
    public int getDutyId() {
        return dutyId;
    }

    public void setDutyId(int dutyId) {
        this.dutyId = dutyId;
    }

    @Basic
    @Column(name = "duty_name")
    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Duty duty = (Duty) o;

        if (dutyId != duty.dutyId) return false;
        if (dutyName != null ? !dutyName.equals(duty.dutyName) : duty.dutyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dutyId;
        result = 31 * result + (dutyName != null ? dutyName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dutyByDutyId", fetch = FetchType.LAZY)
    public List<DutyPermission> getDutyPermissionsByDutyId() {
        return dutyPermissionsByDutyId;
    }

    public void setDutyPermissionsByDutyId(List<DutyPermission> dutyPermissionsByDutyId) {
        this.dutyPermissionsByDutyId = dutyPermissionsByDutyId;
    }

    @OneToMany(mappedBy = "dutyByTeamId", fetch = FetchType.LAZY)
    public List<TeamEmployeeJob> getTeamEmployeeJobsByDutyId() {
        return teamEmployeeJobsByDutyId;
    }

    public void setTeamEmployeeJobsByDutyId(List<TeamEmployeeJob> teamEmployeeJobsByDutyId) {
        this.teamEmployeeJobsByDutyId = teamEmployeeJobsByDutyId;
    }
}
