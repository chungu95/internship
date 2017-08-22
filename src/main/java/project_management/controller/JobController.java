package project_management.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project_management.api.WebURL;
import project_management.repository.model.Job;
import project_management.service.service_interface.JobService;

@Controller
public class JobController {
    private static final Logger LOGGER = Logger.getLogger(JobController.class);
    private final JobService jobService;

    @Autowired
    public JobController(@Qualifier("jobService") JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(value = WebURL.JOB.VIEW_JOB_DETAIL, method = RequestMethod.GET)
    public String viewJobDetail(Model model, @PathVariable("jobId") Integer jobId) {
        LOGGER.info("JobController -> Redirect to view job detail page");
        Job job = jobService.getJobById(jobId);
        model.addAttribute("job", job);
        return "job-detail";
    }

    @RequestMapping(value = WebURL.JOB.ADD_NEW_JOB, method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewJob(Job job) {
        LOGGER.info("JobController -> Add new job");
        jobService.addJob(job);
        if (job.getParentId() != null)
            return "redirect:/job-detail/" + job.getParentId();
        else
            return "redirect:/project-detail/" + job.getProjId();
    }
}
