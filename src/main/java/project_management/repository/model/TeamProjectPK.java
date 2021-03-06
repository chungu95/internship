package project_management.repository.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TeamProjectPK implements Serializable {
    private int teamId;
    private int projId;

    @Column(name = "team_id")
    @Id
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Column(name = "proj_id")
    @Id
    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamProjectPK that = (TeamProjectPK) o;

        if (teamId != that.teamId) return false;
        if (projId != that.projId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teamId;
        result = 31 * result + projId;
        return result;
    }
}
