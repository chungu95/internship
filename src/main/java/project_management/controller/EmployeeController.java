package project_management.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project_management.api.StatusMessage;
import project_management.api.WebURL;
import project_management.repository.model.Employee;
import project_management.service.service_interface.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {
    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());
    private final EmployeeService employeeService;
    private final StatusMessage statusMessage;

    @Autowired
    public EmployeeController(@Qualifier("employeeService") EmployeeService employeeService,
                              @Qualifier("statusMessage") StatusMessage statusMessage) {
        this.employeeService = employeeService;
        this.statusMessage = statusMessage;
    }

    @RequestMapping(value = WebURL.EMPLOYEE.CREATE_NEW_EMPLOYEE_PAGE, method = RequestMethod.GET)
    public String addEmployeePage() {
        LOGGER.info("EmployeeController -> Redirect to add-employee page");
        return "add-employee";
    }

    @RequestMapping(value = WebURL.EMPLOYEE.CREATE_NEW_EMPLOYEE,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            method = RequestMethod.POST)
    @ResponseBody
    public project_management.common.model.StatusMessage addNewEmployee(Employee employee) {
        LOGGER.info("EmployeeController -> Add new employee");
        if (employeeService.addEmployee(employee) != null) {
            return statusMessage.success();
        } else {
            return statusMessage.fail();
        }
    }

    @RequestMapping(value = WebURL.EMPLOYEE.EDIT_EMPLOYEE_PAGE, method = RequestMethod.GET)
    public String editEmployeePage(Model model, @PathVariable ("empId") Integer id) {
        LOGGER.info("EmployeeController -> Redirect to edit-employee page");
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "edit-employee";
    }

    @RequestMapping(value = WebURL.EMPLOYEE.UPDATE_EMPLOYEE, method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editEmployee(Employee employee){
        LOGGER.info("EmployeeController -> Update employee");
        employeeService.updateEmployee(employee);
        return "redirect:"+WebURL.EMPLOYEE.ALL_EMPLOYEE_PAGE;
    }

    @RequestMapping(value = WebURL.EMPLOYEE.ALL_EMPLOYEE_PAGE, method = RequestMethod.GET)
    public String allEmployeesPage(Model model) {
        LOGGER.info("EmployeeController -> View all employees");
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "all-employees";
    }

    @RequestMapping(value = WebURL.EMPLOYEE.DELETE_EMPLOYEE, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable Integer empId){
        LOGGER.info("EmployeeController -> Delete employee by id");
        employeeService.deleteEmployee(empId);
        return "redirect:/"+WebURL.EMPLOYEE.ALL_EMPLOYEE_PAGE;
    }

}
