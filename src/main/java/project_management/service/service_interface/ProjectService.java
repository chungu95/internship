package project_management.service.service_interface;

import project_management.repository.model.Project;

import java.util.List;

public interface ProjectService {
    Project addProject (Project project);
    void updateProject (Project project);
    void deleteProject (Project project);
    void deleteProject (Integer id);
    List<Project> getAllProject ();
    Project getProjectById(Integer id);
    boolean checkProjectKeyIfExist(String key);
}
