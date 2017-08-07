package project_management.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project_management.repository.model.Job;

@Repository("jobRepository")
public interface JobRepository extends JpaRepository<Job,Integer> {
}
