package project_management.repository.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ProjectPhasePK implements Serializable {
    private int projId;
    private int phaseId;

    @Column(name = "proj_id")
    @Id
    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    @Column(name = "phase_id")
    @Id
    public int getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectPhasePK that = (ProjectPhasePK) o;

        if (projId != that.projId) return false;
        if (phaseId != that.phaseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projId;
        result = 31 * result + phaseId;
        return result;
    }
}
