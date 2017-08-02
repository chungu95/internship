package project_management.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {
    private int jobId;
    private int projId;
    private int phaseId;
    private int teamId;
    private String jobName;
    private String jobDescription;
    private int status;
    private Long estimateTime;
    private Integer parentId;
    private Project projectByProjId;
    private Phase phaseByPhaseId;
    private Job jobByParentId;
    private List<Job> jobsByJobId;
    private List<PhaseJob> phaseJobsByJobId;
    private List<TeamEmployeeJob> teamEmployeeJobsByJobId;

    @Id
    @Column(name = "job_id")
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "proj_id")
    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    @Basic
    @Column(name = "phase_id")
    public int getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    @Basic
    @Column(name = "team_id")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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
    @Column(name = "job_description")
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (jobId != job.jobId) return false;
        if (projId != job.projId) return false;
        if (phaseId != job.phaseId) return false;
        if (teamId != job.teamId) return false;
        if (status != job.status) return false;
        if (jobName != null ? !jobName.equals(job.jobName) : job.jobName != null) return false;
        if (jobDescription != null ? !jobDescription.equals(job.jobDescription) : job.jobDescription != null)
            return false;
        if (estimateTime != null ? !estimateTime.equals(job.estimateTime) : job.estimateTime != null) return false;
        if (parentId != null ? !parentId.equals(job.parentId) : job.parentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobId;
        result = 31 * result + projId;
        result = 31 * result + phaseId;
        result = 31 * result + teamId;
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        result = 31 * result + (jobDescription != null ? jobDescription.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (estimateTime != null ? estimateTime.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
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
    @JoinColumn(name = "phase_id", referencedColumnName = "phase_id", nullable = false, insertable = false, updatable = false)
    public Phase getPhaseByPhaseId() {
        return phaseByPhaseId;
    }

    public void setPhaseByPhaseId(Phase phaseByPhaseId) {
        this.phaseByPhaseId = phaseByPhaseId;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "job_id", insertable = false, updatable = false)
    public Job getJobByParentId() {
        return jobByParentId;
    }

    public void setJobByParentId(Job jobByParentId) {
        this.jobByParentId = jobByParentId;
    }

    @OneToMany(mappedBy = "jobByParentId")
    public List<Job> getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(List<Job> jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }

    @OneToMany(mappedBy = "jobByJobId")
    public List<PhaseJob> getPhaseJobsByJobId() {
        return phaseJobsByJobId;
    }

    public void setPhaseJobsByJobId(List<PhaseJob> phaseJobsByJobId) {
        this.phaseJobsByJobId = phaseJobsByJobId;
    }

    @OneToMany(mappedBy = "jobByJobId")
    public List<TeamEmployeeJob> getTeamEmployeeJobsByJobId() {
        return teamEmployeeJobsByJobId;
    }

    public void setTeamEmployeeJobsByJobId(List<TeamEmployeeJob> teamEmployeeJobsByJobId) {
        this.teamEmployeeJobsByJobId = teamEmployeeJobsByJobId;
    }
}
