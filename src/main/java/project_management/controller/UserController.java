package project_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project_management.repository.model.Users;
import project_management.repository.repository.EmployeeRepository;
import project_management.repository.repository.UserRepository;
import project_management.service.service_interface.UserService;

import java.util.logging.Logger;

@Controller
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Users add() {
//        for(int i = 0; i<100000;i++){
//            LOGGER.info("Save lần thứ "+i);
//            Users user = new Users();
//            user.setUsername("a"+i);
//            user.setPassword("123");
//            user.setUserEmail("Chung"+i+"@gmail.com");
//            user.setUserType("employee");
//            userRepository.save(user);
//        }
        return userRepository.findOne(1);
    }

//    @ResponseBody
//    @RequestMapping(value= "add_ep", method = RequestMethod.GET)
//    public Employee add_ep(){
//        Employee ep = new Employee();
//        ep.setEpName("chung");
//        ep.setEpAddress("HCMC");
//        ep.setEpDayofbirth(new Date(1995,02,10));
//        ep.setEpEmail("chung");
//        ep.setEpPhoneNumber("0988457017");
//        ep.setUserId(1);
//        return employeeRepository.save(ep);
//    }

}
