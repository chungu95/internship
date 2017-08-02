package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "PHASE_JOB")
@IdClass(PhaseJobPK.class)
public class PhaseJob {
    private int phaseId;
    private int jobId;
    private Phase phaseByPhaseId;
    private Job jobByJobId;

    @Id
    @Column(name = "phase_id")
    public int getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    @Id
    @Column(name = "job_id")
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhaseJob phaseJob = (PhaseJob) o;

        if (phaseId != phaseJob.phaseId) return false;
        if (jobId != phaseJob.jobId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phaseId;
        result = 31 * result + jobId;
        return result;
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
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", nullable = false, insertable = false, updatable = false)
    public Job getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(Job jobByJobId) {
        this.jobByJobId = jobByJobId;
    }
}
