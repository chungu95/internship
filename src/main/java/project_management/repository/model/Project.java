package project_management.repository.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Project {
    private int projId;
    private int pmId;
    private String projName;
    private String projKey;
    private Timestamp createTime;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer status;
    private List<Job> jobsByProjId;
    private List<ProjectPhase> projectPhasesByProjId;
    private List<TeamProject> teamProjectsByProjId;

    @Id
    @Column(name = "proj_id")
    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    @Basic
    @Column(name = "pm_id")
    public int getPmId() {
        return pmId;
    }

    public void setPmId(int pmId) {
        this.pmId = pmId;
    }

    @Basic
    @Column(name = "proj_name")
    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    @Basic
    @Column(name = "proj_key")
    public String getProjKey() {
        return projKey;
    }

    public void setProjKey(String projKey) {
        this.projKey = projKey;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (projId != project.projId) return false;
        if (pmId != project.pmId) return false;
        if (projName != null ? !projName.equals(project.projName) : project.projName != null) return false;
        if (projKey != null ? !projKey.equals(project.projKey) : project.projKey != null) return false;
        if (createTime != null ? !createTime.equals(project.createTime) : project.createTime != null) return false;
        if (startTime != null ? !startTime.equals(project.startTime) : project.startTime != null) return false;
        if (endTime != null ? !endTime.equals(project.endTime) : project.endTime != null) return false;
        if (status != null ? !status.equals(project.status) : project.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projId;
        result = 31 * result + pmId;
        result = 31 * result + (projName != null ? projName.hashCode() : 0);
        result = 31 * result + (projKey != null ? projKey.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "projectByProjId")
    public List<Job> getJobsByProjId() {
        return jobsByProjId;
    }

    public void setJobsByProjId(List<Job> jobsByProjId) {
        this.jobsByProjId = jobsByProjId;
    }

    @OneToMany(mappedBy = "projectByProjId")
    public List<ProjectPhase> getProjectPhasesByProjId() {
        return projectPhasesByProjId;
    }

    public void setProjectPhasesByProjId(List<ProjectPhase> projectPhasesByProjId) {
        this.projectPhasesByProjId = projectPhasesByProjId;
    }

    @OneToMany(mappedBy = "projectByProjId")
    public List<TeamProject> getTeamProjectsByProjId() {
        return teamProjectsByProjId;
    }

    public void setTeamProjectsByProjId(List<TeamProject> teamProjectsByProjId) {
        this.teamProjectsByProjId = teamProjectsByProjId;
    }
}
