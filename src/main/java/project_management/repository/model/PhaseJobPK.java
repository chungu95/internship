package project_management.repository.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PhaseJobPK implements Serializable {
    private int phaseId;
    private int jobId;

    @Column(name = "phase_id")
    @Id
    public int getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    @Column(name = "job_id")
    @Id
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

        PhaseJobPK that = (PhaseJobPK) o;

        if (phaseId != that.phaseId) return false;
        if (jobId != that.jobId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phaseId;
        result = 31 * result + jobId;
        return result;
    }
}
