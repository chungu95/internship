package project_management.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    private int teamId;
    private String teamName;
    private Integer leaderId;
    private List<TeamEmployeeJob> teamEmployeeJobsByTeamId;
    private List<TeamProject> teamProjectsByTeamId;

    @Id
    @Column(name = "team_id")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "team_name")
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Basic
    @Column(name = "leader_id")
    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (teamId != team.teamId) return false;
        if (teamName != null ? !teamName.equals(team.teamName) : team.teamName != null) return false;
        if (leaderId != null ? !leaderId.equals(team.leaderId) : team.leaderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teamId;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (leaderId != null ? leaderId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public List<TeamEmployeeJob> getTeamEmployeeJobsByTeamId() {
        return teamEmployeeJobsByTeamId;
    }

    public void setTeamEmployeeJobsByTeamId(List<TeamEmployeeJob> teamEmployeeJobsByTeamId) {
        this.teamEmployeeJobsByTeamId = teamEmployeeJobsByTeamId;
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public List<TeamProject> getTeamProjectsByTeamId() {
        return teamProjectsByTeamId;
    }

    public void setTeamProjectsByTeamId(List<TeamProject> teamProjectsByTeamId) {
        this.teamProjectsByTeamId = teamProjectsByTeamId;
    }
}
