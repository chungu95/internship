package project_management.service.implementation;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_management.api.DateApi;
import project_management.repository.model.Employee;
import project_management.repository.model.TeamEmployeeJob;
import project_management.repository.model.Users;
import project_management.repository.repository.EmployeeRepository;
import project_management.repository.repository.UserRepository;
import project_management.service.service_interface.EmployeeService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class.getName());
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        LOGGER.info("EmployeeService -> Add new employee");
        try {
            employee.setIsDeleted(0);
            Users user = new Users();
            user.setUserType("employee");
            user.setUsername(employee.getEpCmt());
            user.setPassword(employee.getEpDayofbirth().toString());
            user = userRepository.save(user);
            employee.setUserId(user.getUserId());
            return employeeRepository.save(employee);
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        LOGGER.info("EmployeeService -> Update employee");
        Employee _employee = employeeRepository.findOne(employee.getEmpId());
        if (_employee != null) {
            prepareEmployeeToUpdate(employee, _employee);
            try {
                employeeRepository.save(_employee);
                return true;
            } catch (HibernateException he) {
                LOGGER.error(he.getMessage());
                return false;
            }
        } else {
            LOGGER.info("Nhân viên không tồn tại");
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        LOGGER.info("EmployeeService -> Remove employee");
        Employee _employee = employeeRepository.findOne(employee.getEmpId());
        if (_employee != null) {
            try {
                employeeRepository.delete(_employee);
                return true;
            } catch (HibernateException he) {
                LOGGER.error(he.getMessage());
                return false;
            }
        } else {
            throw new EntityNotFoundException("Nhân viên không tồn tại");
        }
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        LOGGER.info("EmployeeService -> Remove employee by employee id");
        try {
            Employee employee = employeeRepository.findOne(id);
            employee.setIsDeleted(1);
            employeeRepository.save(employee);
            return true;
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return false;
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        LOGGER.info("EmployeeService -> Get all employees");
        List<Employee> employees = null;
        try {
            employees = employeeRepository.findAllByIsDeletedOrderByEpName(0);
            employees.forEach(employee -> {
                setEmployeeStatus(employee);
            });
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        LOGGER.info("EmployeeService -> Get employee by id");
        try {
            Employee employee = employeeRepository.findOne(id);
            setEmployeeStatus(employee);
            return employee;
        } catch (HibernateException he) {
            LOGGER.error(he.getMessage());
            return null;
        }
    }

    private void setEmployeeStatus(Employee employee) {
        if (employee == null) return;
        List<TeamEmployeeJob> teamEmployeeJobs = employee.getTeamEmployeeJobsByEmpId();
        for (int i = 0; i < teamEmployeeJobs.size(); i++) {
            if (!DateApi.getCurrentDate().after(teamEmployeeJobs.get(i).getStartTime()) && !DateApi.getCurrentDate().before(teamEmployeeJobs.get(i).getEndTime())) {
                employee.setStatus("BUSY");
                break;
            }
        }
    }

    private void prepareEmployeeToUpdate(Employee from, Employee to) {
        to.setEpEmail(from.getEpEmail());
        to.setEpAddress(from.getEpAddress());
        to.setEpName(from.getEpName());
        to.setEpDayofbirth(from.getEpDayofbirth());
        to.setEpPhoneNumber(from.getEpPhoneNumber());
    }


}
