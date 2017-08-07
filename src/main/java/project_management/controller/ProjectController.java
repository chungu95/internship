package project_management.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project_management.api.WebURL;
import project_management.repository.model.Project;
import project_management.service.service_interface.ProjectService;

import java.util.List;

@Controller
public class ProjectController {
    private static final Logger LOGGER = Logger.getLogger(ProjectController.class.getName());
    private final ProjectService projectService;

    @Autowired
    public ProjectController (@Qualifier("projectService") ProjectService projectService){
        this.projectService = projectService;
    }

    @RequestMapping(value = WebURL.PROJECT.GET_ALL_PROJECTS, method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getAllProjects(){
        return projectService.getAllProject();
    }
}
