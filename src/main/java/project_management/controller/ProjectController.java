package project_management.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project_management.api.WebURL;
import project_management.repository.model.Employee;
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
    public String addNewProjectPage(Model model) {
        LOGGER.info("ProjectController -> Redirect to new project page");
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "new-project";
    }

    @RequestMapping(value = WebURL.PROJECT.ADD_NEW_PROJECT, method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewProject(Project project) {
        LOGGER.info("ProjectController -> Add new project");
        projectService.addProject(project);
        return "redirect:/" + WebURL.PROJECT.ALL_PROJECTS_PAGE;
    }

    @RequestMapping(value = WebURL.PROJECT.VIEW_PROJECT_DETAIL, method = RequestMethod.GET)
    public String viewProjectDetail(Model model, @PathVariable("projId") Integer projId) {
        LOGGER.info("ProjectController -> View detail of project has id: " + projId);
        Project project = projectService.getProjectById(projId);
        Employee employee = employeeService.getEmployeeById(project.getPmId());
        model.addAttribute("project", project);
        model.addAttribute("manager", employee);
        return "project-detail";
    }

    @RequestMapping(value = WebURL.PROJECT.CHECK_PROJECT_KEY, method = RequestMethod.GET)
    @ResponseBody
    public String checkProjectKeyIfExist(@RequestParam(value = "projKey") String projKey) {
        if (projectService.checkProjectKeyIfExist(projKey)) {
            return "no";
        } else {
            return "ok";
        }
    }
}
