package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT_PHASE")
@IdClass(ProjectPhasePK.class)
public class ProjectPhase {
    private int projId;
    private int phaseId;
    private String phaseDescription;
    private Project projectByProjId;
    private Phase phaseByPhaseId;

    @Id
    @Column(name = "proj_id")
    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    @Id
    @Column(name = "phase_id")
    public int getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    @Basic
    @Column(name = "phase_description")
    public String getPhaseDescription() {
        return phaseDescription;
    }

    public void setPhaseDescription(String phaseDescription) {
        this.phaseDescription = phaseDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectPhase that = (ProjectPhase) o;

        if (projId != that.projId) return false;
        if (phaseId != that.phaseId) return false;
        if (phaseDescription != null ? !phaseDescription.equals(that.phaseDescription) : that.phaseDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projId;
        result = 31 * result + phaseId;
        result = 31 * result + (phaseDescription != null ? phaseDescription.hashCode() : 0);
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
}
