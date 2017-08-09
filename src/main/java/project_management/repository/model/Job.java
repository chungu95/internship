package project_management.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {
    private Integer jobId;
    private Long estimateTime;
    private String jobDescription;
    private String jobName;
    private Integer parentId;
    private Integer phaseId;
    private Integer projId;
    private Integer status;
    private Integer teamId;
    private Job jobByParentId;
    private List<Job> jobsByJobId;
    private Phase phaseByPhaseId;
    private Project projectByProjId;
    private List<PhaseJob> phaseJobsByJobId;
    private List<TeamEmployeeJob> teamEmployeeJobsByJobId;

    @Id
    @Column(name = "job_id")
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "estimate_time")
    public Long getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(Long estimateTime) {
        this.estimateTime = estimateTime;
    }

    @Basic
    @Column(name = "job_description")
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Basic
    @Column(name = "job_name")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Basic
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "phase_id")
    public Integer getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Integer phaseId) {
        this.phaseId = phaseId;
    }

    @Basic
    @Column(name = "proj_id")
    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "team_id")
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (jobId != job.jobId) return false;
        if (estimateTime != null ? !estimateTime.equals(job.estimateTime) : job.estimateTime != null) return false;
        if (jobDescription != null ? !jobDescription.equals(job.jobDescription) : job.jobDescription != null)
            return false;
        if (jobName != null ? !jobName.equals(job.jobName) : job.jobName != null) return false;
        if (parentId != null ? !parentId.equals(job.parentId) : job.parentId != null) return false;
        if (phaseId != null ? !phaseId.equals(job.phaseId) : job.phaseId != null) return false;
        if (projId != null ? !projId.equals(job.projId) : job.projId != null) return false;
        if (status != null ? !status.equals(job.status) : job.status != null) return false;
        if (teamId != null ? !teamId.equals(job.teamId) : job.teamId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobId;
        result = 31 * result + (estimateTime != null ? estimateTime.hashCode() : 0);
        result = 31 * result + (jobDescription != null ? jobDescription.hashCode() : 0);
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (phaseId != null ? phaseId.hashCode() : 0);
        result = 31 * result + (projId != null ? projId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (teamId != null ? teamId.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "parent_id", referencedColumnName = "job_id", insertable = false, updatable = false)
    public Job getJobByParentId() {
        return jobByParentId;
    }

    public void setJobByParentId(Job jobByParentId) {
        this.jobByParentId = jobByParentId;
    }

    @OneToMany(mappedBy = "jobByParentId", fetch = FetchType.LAZY)
    public List<Job> getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(List<Job> jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "phase_id", referencedColumnName = "phase_id", insertable = false, updatable = false)
    public Phase getPhaseByPhaseId() {
        return phaseByPhaseId;
    }

    public void setPhaseByPhaseId(Phase phaseByPhaseId) {
        this.phaseByPhaseId = phaseByPhaseId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "proj_id", referencedColumnName = "proj_id", insertable = false, updatable = false)
    public Project getProjectByProjId() {
        return projectByProjId;
    }

    public void setProjectByProjId(Project projectByProjId) {
        this.projectByProjId = projectByProjId;
    }

    @OneToMany(mappedBy = "jobByJobId", fetch = FetchType.LAZY)
    public List<PhaseJob> getPhaseJobsByJobId() {
        return phaseJobsByJobId;
    }

    public void setPhaseJobsByJobId(List<PhaseJob> phaseJobsByJobId) {
        this.phaseJobsByJobId = phaseJobsByJobId;
    }

    @OneToMany(mappedBy = "jobByJobId", fetch = FetchType.LAZY)
    public List<TeamEmployeeJob> getTeamEmployeeJobsByJobId() {
        return teamEmployeeJobsByJobId;
    }

    public void setTeamEmployeeJobsByJobId(List<TeamEmployeeJob> teamEmployeeJobsByJobId) {
        this.teamEmployeeJobsByJobId = teamEmployeeJobsByJobId;
    }
}
