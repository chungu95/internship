package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "team_project")
@IdClass(TeamProjectPK.class)
public class TeamProject {
    private int teamId;
    private int projId;
    private Team teamByTeamId;
    private Project projectByProjId;

    @Id
    @Column(name = "team_id")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Id
    @Column(name = "proj_id")
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

        TeamProject that = (TeamProject) o;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false, insertable = false, updatable = false)
    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id", nullable = false, insertable = false, updatable = false)
    public Project getProjectByProjId() {
        return projectByProjId;
    }

    public void setProjectByProjId(Project projectByProjId) {
        this.projectByProjId = projectByProjId;
    }
}
