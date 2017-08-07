package project_management.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import project_management.repository.model.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
