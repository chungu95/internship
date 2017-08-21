package project_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project_management.repository.model.Job;
import project_management.repository.repository.JobRepository;
import project_management.service.service_interface.JobService;

import java.util.logging.Logger;

@Controller
public class test {
    private static final Logger LOGGER = Logger.getLogger(test.class.getName());

    @Autowired
    private JobService jobRepository;

    @RequestMapping("/")
    public String test(Model model) {
        LOGGER.info("REDIRECT TO HOME");
        Job job = jobRepository.getJobById(1);
        model.addAttribute("job",job);
        return "jobs-tree";
    }

    @RequestMapping("/403")
    public String testa() {
        return "403";
    }

}
