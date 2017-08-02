package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "TEAM_PROJECT")
@IdClass(TeamProjectPK.class)
public class TeamProject {
    private int projId;
    private int teamId;
    private Project projectByProjId;
    private Team teamByTeamId;

    @Id
    @Column(name = "proj_id")
    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    @Id
    @Column(name = "team_id")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamProject that = (TeamProject) o;

        if (projId != that.projId) return false;
        if (teamId != that.teamId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projId;
        result = 31 * result + teamId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id", nullable = false, insertable = false, updatable = false)
    public Project getProjectByProjId() {
        return projectByProjId;
    }

    public void setProjectByProjId(Project projectByProjId) {
        this.projectByProjId = projectByProjId;
    }

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false, insertable = false, updatable = false)
    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }
}
