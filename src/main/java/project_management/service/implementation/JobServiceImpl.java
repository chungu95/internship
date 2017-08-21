package project_management.service.implementation;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_management.repository.model.Job;
import project_management.repository.repository.JobRepository;
import project_management.service.service_interface.JobService;

import javax.persistence.EntityNotFoundException;
import java.util.Calendar;
import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService {
    private static final Logger LOGGER = Logger.getLogger(JobServiceImpl.class);
    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job addJob(Job job) {
        LOGGER.info("JobService -> Add new Job");
        job.setStatus(0);
        try {
            return jobRepository.save(job);
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return null;
        }
    }

    @Override
    public void updateJob(Job job) {
        LOGGER.info("JobService -> Update job (" + job.getJobId() + ")");
        Job job1 = jobRepository.findOne(job.getProjId());
        if (job1 != null) {
            prepareEntityToUpdate(job, job1);
            try {
                jobRepository.save(job1);
            } catch (HibernateException he) {
                LOGGER.error(he.getMessage());
            }
        } else {
            throw new EntityNotFoundException("Job không tồn tại");
        }
    }

    @Override
    public boolean deleteJob(Job job) {
        LOGGER.info("JobService -> Delete a Job");
        try {
            Job job1 = jobRepository.findOne(job.getJobId());
            if (job1 != null) {
                jobRepository.delete(job1);
                return true;
            } else return false;
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteJob(Integer id) {
        LOGGER.info("JobService -> Remove Job by job id");
        try {
            jobRepository.delete(id);
            return true;
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return false;
        }
    }

    @Override
    public List<Job> getAllJobs() {
        LOGGER.info("JobService -> Get all jobs");
        List<Job> jobs = null;
        try {
            jobs = jobRepository.findAll();
            setUpDisplayStatus(jobs);
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
        }
        return jobs;
    }

    @Override
    public List<Job> getAllJobByProjectId(Integer id) {
        LOGGER.info("JobService -> Get jobs by project id");
        try {
            List<Job> jobs = jobRepository.findAllByProjId(id);
            setUpDisplayStatus(jobs);
            return jobs;
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return null;
        }
    }

    @Override
    public List<Job> getAllJobByParentId(Integer id) {
        LOGGER.info("JobService -> Get job parent job id");
        try {
            List<Job> jobs = jobRepository.findAllByParentId(id);
            setUpDisplayStatus(jobs);
            return jobs;
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return null;
        }
    }

    @Override
    public Job getJobById(Integer id) {
        LOGGER.info("JobService -> Get job by id");
        try {
            Job job = jobRepository.findOne(id);
            setUpDisplayStatus(job.getJobsByJobId());
            return job;
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return null;
        }
    }

    private void prepareEntityToUpdate(Job from, Job to) {
        to.setJobName(from.getJobName());
        to.setStatus(from.getStatus());
        to.setEstimateTime(from.getEstimateTime());
        to.setTeamId(from.getTeamId());
    }

    public void setUpDisplayStatus(List<Job> jobs) {
        Calendar currentDate = Calendar.getInstance();
        if (jobs == null || jobs.size() == 0) return;
        jobs.forEach(job -> {
            if (job.getStatus() == 0) {
                java.util.Date date = new java.util.Date(job.getStartTime().getTime());
                if (date.after(currentDate.getTime())) {
                    job.setDisplayStatus(0);
                } else {
                    job.setDisplayStatus(1);
                }
            } else {
                job.setDisplayStatus(2);
            }
        });
    }
}
