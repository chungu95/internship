package project_management.repository.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Phase {
    private int phaseId;
    private String description;
    private Long estimateTime;
    private String phaseName;
    private Date startTime;
    private List<Job> jobsByPhaseId;
    private List<PhaseJob> phaseJobsByPhaseId;
    private List<ProjectPhase> projectPhasesByPhaseId;

    @Id
    @Column(name = "phase_id")
    public int getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "phase_name")
    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    @Basic
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phase phase = (Phase) o;

        if (phaseId != phase.phaseId) return false;
        if (description != null ? !description.equals(phase.description) : phase.description != null) return false;
        if (estimateTime != null ? !estimateTime.equals(phase.estimateTime) : phase.estimateTime != null) return false;
        if (phaseName != null ? !phaseName.equals(phase.phaseName) : phase.phaseName != null) return false;
        if (startTime != null ? !startTime.equals(phase.startTime) : phase.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phaseId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (estimateTime != null ? estimateTime.hashCode() : 0);
        result = 31 * result + (phaseName != null ? phaseName.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "phaseByPhaseId", fetch = FetchType.LAZY)
    public List<Job> getJobsByPhaseId() {
        return jobsByPhaseId;
    }

    public void setJobsByPhaseId(List<Job> jobsByPhaseId) {
        this.jobsByPhaseId = jobsByPhaseId;
    }

    @OneToMany(mappedBy = "phaseByPhaseId", fetch = FetchType.LAZY)
    public List<PhaseJob> getPhaseJobsByPhaseId() {
        return phaseJobsByPhaseId;
    }

    public void setPhaseJobsByPhaseId(List<PhaseJob> phaseJobsByPhaseId) {
        this.phaseJobsByPhaseId = phaseJobsByPhaseId;
    }

    @OneToMany(mappedBy = "phaseByPhaseId", fetch = FetchType.LAZY)
    public List<ProjectPhase> getProjectPhasesByPhaseId() {
        return projectPhasesByPhaseId;
    }

    public void setProjectPhasesByPhaseId(List<ProjectPhase> projectPhasesByPhaseId) {
        this.projectPhasesByPhaseId = projectPhasesByPhaseId;
    }
}
