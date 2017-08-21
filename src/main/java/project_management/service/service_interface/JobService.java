package project_management.service.service_interface;

import project_management.repository.model.Job;

import java.util.List;

public interface JobService {
    Job addJob(Job job);

    void updateJob(Job job);

    boolean deleteJob(Job job);

    boolean deleteJob(Integer id);

    List<Job> getAllJobs();

    List<Job> getAllJobByProjectId(Integer id);

    List<Job> getAllJobByParentId(Integer id);

    Job getJobById(Integer id);

    void setUpDisplayStatus(List<Job> job);
}
