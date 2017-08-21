package project_management.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_management.repository.model.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findAllByProjId(Integer id);
    List<Job> findAllByParentId(Integer id);
}
