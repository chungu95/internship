package project_management.repository.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "team_employee_job")
public class TeamEmployeeJob {
    private int id;
    private Integer teamId;
    private Integer epId;
    private Integer dutyId;
    private Integer jobId;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer status;
    private TeamStockEmployee teamStockEmployeeById;
    private TeamTackleEmployee teamTackleEmployeeById;
    private Team teamByTeamId;
    private Duty dutyByTeamId;
    private Employee employeeByEpId;
    private Job jobByJobId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "team_id")
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "ep_id")
    public Integer getEpId() {
        return epId;
    }

    public void setEpId(Integer epId) {
        this.epId = epId;
    }

    @Basic
    @Column(name = "duty_id")
    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
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

        TeamEmployeeJob that = (TeamEmployeeJob) o;

        if (id != that.id) return false;
        if (teamId != null ? !teamId.equals(that.teamId) : that.teamId != null) return false;
        if (epId != null ? !epId.equals(that.epId) : that.epId != null) return false;
        if (dutyId != null ? !dutyId.equals(that.dutyId) : that.dutyId != null) return false;
        if (jobId != null ? !jobId.equals(that.jobId) : that.jobId != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (teamId != null ? teamId.hashCode() : 0);
        result = 31 * result + (epId != null ? epId.hashCode() : 0);
        result = 31 * result + (dutyId != null ? dutyId.hashCode() : 0);
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "teamEmployeeJobById", fetch = FetchType.LAZY)
    public TeamStockEmployee getTeamStockEmployeeById() {
        return teamStockEmployeeById;
    }

    public void setTeamStockEmployeeById(TeamStockEmployee teamStockEmployeeById) {
        this.teamStockEmployeeById = teamStockEmployeeById;
    }

    @OneToOne(mappedBy = "teamEmployeeJobById", fetch = FetchType.LAZY)
    public TeamTackleEmployee getTeamTackleEmployeeById() {
        return teamTackleEmployeeById;
    }

    public void setTeamTackleEmployeeById(TeamTackleEmployee teamTackleEmployeeById) {
        this.teamTackleEmployeeById = teamTackleEmployeeById;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", insertable = false, updatable = false)
    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "duty_id", insertable = false, updatable = false)
    public Duty getDutyByTeamId() {
        return dutyByTeamId;
    }

    public void setDutyByTeamId(Duty dutyByTeamId) {
        this.dutyByTeamId = dutyByTeamId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ep_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
    public Employee getEmployeeByEpId() {
        return employeeByEpId;
    }

    public void setEmployeeByEpId(Employee employeeByEpId) {
        this.employeeByEpId = employeeByEpId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", insertable = false, updatable = false)
    public Job getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(Job jobByJobId) {
        this.jobByJobId = jobByJobId;
    }
}
