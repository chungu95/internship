package project_management.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project_management.api.WebURL;
import project_management.repository.model.Project;
import project_management.service.service_interface.EmployeeService;
import project_management.service.service_interface.ProjectService;

import java.util.List;

@Controller
public class ProjectController {
    private static final Logger LOGGER = Logger.getLogger(ProjectController.class.getName());
    private final ProjectService projectService;
    private final EmployeeService employeeService;

    @Autowired
    public ProjectController(@Qualifier("projectService") ProjectService projectService,
                             @Qualifier("employeeService") EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @RequestMapping(value = WebURL.PROJECT.ALL_PROJECTS_PAGE, method = RequestMethod.GET)
    public String getAllProjects(Model model) {
        LOGGER.info("ProjectController -> Redirect to all-project page");
        List<Project> projects = projectService.getAllProject();
        model.addAttribute("projects", projects);
        return "all-projects";
    }

    @RequestMapping(value = WebURL.PROJECT.ADD_NEW_PROJECT_PAGE, method = RequestMethod.GET)
    public String addNewProjectPage() {
        LOGGER.info("ProjectController -> Redirect to new project page");
        return "new-project";
    }

    @RequestMapping(value = WebURL.PROJECT.ADD_NEW_PROJECT, method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewProject(Project project) {
        projectService.addProject(project);
        return "redirect:/" + WebURL.PROJECT.ALL_PROJECTS_PAGE;
    }

    @RequestMapping(value = "checkProjKey", method = RequestMethod.GET)
    @ResponseBody
    public String checkProjectKeyIfExist(@RequestParam(value = "projKey") String projKey) {
        if (projectService.checkProjectKeyIfExist(projKey)) {
            return "no";
        } else {
            return "ok";
        }
    }
}
