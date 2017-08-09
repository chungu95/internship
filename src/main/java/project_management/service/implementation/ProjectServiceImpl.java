package project_management.service.implementation;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_management.api.DateApi;
import project_management.repository.model.Project;
import project_management.repository.repository.ProjectRepository;
import project_management.service.service_interface.ProjectService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    private static final Logger LOGGER = Logger.getLogger(ProjectServiceImpl.class.getName());
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project addProject(Project project) {
        LOGGER.info("ProjectService -> Add new project");
        project.setCreateTime(DateApi.getCurrentDate());
        project.setStatus(0);
        try {
            return projectRepository.save(project);
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return null;
        }
    }

    @Override
    public void updateProject(Project project) {
        LOGGER.info("ProjectService -> Update project");
        Project proj = projectRepository.findOne(project.getProjId());
        if (proj != null) {
            try {
                projectRepository.save(proj);
            } catch (HibernateException he) {
                LOGGER.error(he.getMessage());
            }
        } else {
            throw new EntityNotFoundException("Project không tồn tại");
        }
    }

    @Override
    public void deleteProject(Project proj) {
        LOGGER.info("ProjectService -> Remove project");
        Project project = projectRepository.findOne(proj.getProjId());
        if (project != null) {
            try {
                projectRepository.delete(project);
            } catch (HibernateException he) {
                LOGGER.error(he.getMessage());
            }
        } else {
            throw new EntityNotFoundException("Project không tồn tại");
        }
    }

    @Override
    public void deleteProject(Integer id) {
        LOGGER.info("ProjectService -> Remove project by project id");
        try {
            projectRepository.delete(id);
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
        }
    }

    @Override
    public List<Project> getAllProject() {
        LOGGER.info("ProjectService -> Get all projects");
        List<Project> projects = null;
        try {
            projects = projectRepository.findAll();
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
        }
        return projects;
    }

    @Override
    public Project getProjectById(Integer id) {
        LOGGER.info("ProjectService -> Get project by id");
        try {
            return projectRepository.findOne(id);
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return null;
        }
    }

    @Override
    public boolean checkProjectKeyIfExist(String key) {
        LOGGER.info("ProjectService -> Check project key if exist");
        if (projectRepository.findProjectByProjKey(key) != null) {
            return true;
        } else {
            return false;
        }
    }
}
