package project_management.repository.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Project {
    private int projId;
    private Date createTime;
    private Date endTime;
    private Integer pmId;
    private String projKey;
    private String projName;
    private Date startTime;
    private Integer status;
    private List<StockProject> stockProjectsByProjId;
    private List<Job> jobsByProjId;
//    private Project projectByProjId;
//    private Project projectByProjId_0;
    private List<ProjectPhase> projectPhasesByProjId;
    private List<TeamProject> teamProjectsByProjId;

    @Id
    @GeneratedValue
    @Column(name = "proj_id")
    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "pm_id")
    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    @Basic
    @Column(name = "proj_key",  unique = true)
    public String getProjKey() {
        return projKey;
    }

    public void setProjKey(String projKey) {
        this.projKey = projKey;
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
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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
        if (createTime != null ? !createTime.equals(project.createTime) : project.createTime != null) return false;
        if (endTime != null ? !endTime.equals(project.endTime) : project.endTime != null) return false;
        if (pmId != null ? !pmId.equals(project.pmId) : project.pmId != null) return false;
        if (projKey != null ? !projKey.equals(project.projKey) : project.projKey != null) return false;
        if (projName != null ? !projName.equals(project.projName) : project.projName != null) return false;
        if (startTime != null ? !startTime.equals(project.startTime) : project.startTime != null) return false;
        if (status != null ? !status.equals(project.status) : project.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projId;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (pmId != null ? pmId.hashCode() : 0);
        result = 31 * result + (projKey != null ? projKey.hashCode() : 0);
        result = 31 * result + (projName != null ? projName.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "projectByProjId", fetch = FetchType.LAZY)
    public List<StockProject> getStockProjectsByProjId() {
        return stockProjectsByProjId;
    }

    public void setStockProjectsByProjId(List<StockProject> stockProjectsByProjId) {
        this.stockProjectsByProjId = stockProjectsByProjId;
    }

    @OneToMany(mappedBy = "projectByProjId", fetch = FetchType.LAZY)
    public List<Job> getJobsByProjId() {
        return jobsByProjId;
    }

    public void setJobsByProjId(List<Job> jobsByProjId) {
        this.jobsByProjId = jobsByProjId;
    }

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id", nullable = false)
//    public Project getProjectByProjId() {
//        return projectByProjId;
//    }
//
//    public void setProjectByProjId(Project projectByProjId) {
//        this.projectByProjId = projectByProjId;
//    }
//
//    @OneToOne(mappedBy = "projectByProjId", fetch = FetchType.LAZY)
//    public Project getProjectByProjId_0() {
//        return projectByProjId_0;
//    }

//    public void setProjectByProjId_0(Project projectByProjId_0) {
//        this.projectByProjId_0 = projectByProjId_0;
//    }

    @OneToMany(mappedBy = "projectByProjId", fetch = FetchType.LAZY)
    public List<ProjectPhase> getProjectPhasesByProjId() {
        return projectPhasesByProjId;
    }

    public void setProjectPhasesByProjId(List<ProjectPhase> projectPhasesByProjId) {
        this.projectPhasesByProjId = projectPhasesByProjId;
    }

    @OneToMany(mappedBy = "projectByProjId", fetch = FetchType.LAZY)
    public List<TeamProject> getTeamProjectsByProjId() {
        return teamProjectsByProjId;
    }

    public void setTeamProjectsByProjId(List<TeamProject> teamProjectsByProjId) {
        this.teamProjectsByProjId = teamProjectsByProjId;
    }
}
