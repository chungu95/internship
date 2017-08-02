package project_management.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "TEAM_EMPLOYEE_JOB")
@IdClass(TeamEmployeeJobPK.class)
public class TeamEmployeeJob {
    private int teamId;
    private int epId;
    private Integer jobId;
    private Integer dutyId;
    private Duty dutyByTeamId;
    private Team teamByTeamId;
    private Employee employeeByEpId;
    private Job jobByJobId;

    @Id
    @Column(name = "team_id")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Id
    @Column(name = "ep_id")
    public int getEpId() {
        return epId;
    }

    public void setEpId(int epId) {
        this.epId = epId;
    }

    @Basic
    @Column(name = "job_id")
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "duty_id")
    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamEmployeeJob that = (TeamEmployeeJob) o;

        if (teamId != that.teamId) return false;
        if (epId != that.epId) return false;
        if (jobId != null ? !jobId.equals(that.jobId) : that.jobId != null) return false;
        if (dutyId != null ? !dutyId.equals(that.dutyId) : that.dutyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teamId;
        result = 31 * result + epId;
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        result = 31 * result + (dutyId != null ? dutyId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "duty_id", nullable = false, insertable = false, updatable = false)
    public Duty getDutyByTeamId() {
        return dutyByTeamId;
    }

    public void setDutyByTeamId(Duty dutyByTeamId) {
        this.dutyByTeamId = dutyByTeamId;
    }

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false, insertable = false, updatable = false)
    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }

    @ManyToOne
    @JoinColumn(name = "ep_id", referencedColumnName = "emp_id", nullable = false, insertable = false, updatable = false)
    public Employee getEmployeeByEpId() {
        return employeeByEpId;
    }

    public void setEmployeeByEpId(Employee employeeByEpId) {
        this.employeeByEpId = employeeByEpId;
    }

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", insertable = false, updatable = false)
    public Job getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(Job jobByJobId) {
        this.jobByJobId = jobByJobId;
    }
}
