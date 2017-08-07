package project_management.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_management.repository.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
