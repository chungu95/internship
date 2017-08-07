package project_management.service.service_interface;

import project_management.repository.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee (Employee employee);
    void updateEmployee (Employee employee);
    void deleteEmployee (Employee employee);
    void deleteEmployee (Integer id);
    List<Employee> getAllEmployee ();
    Employee getEmployeeById(Integer id);
}
