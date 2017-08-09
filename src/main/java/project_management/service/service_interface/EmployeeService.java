package project_management.service.service_interface;

import project_management.repository.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee (Employee employee);
    boolean updateEmployee (Employee employee);
    boolean deleteEmployee (Employee employee);
    boolean deleteEmployee (Integer id);
    List<Employee> getAllEmployee ();
    Employee getEmployeeById(Integer id);
}
