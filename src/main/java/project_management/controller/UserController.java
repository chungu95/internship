package project_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project_management.api.WebURL;
import project_management.repository.model.Users;
import project_management.repository.repository.EmployeeRepository;
import project_management.repository.repository.UserRepository;
import project_management.service.service_interface.UserService;

import javax.print.attribute.standard.Media;
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
    @RequestMapping(value = "add-new-user", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Users add(Users user) {

//        for(int i = 0; i<100000;i++){
//            LOGGER.info("Save lần thứ "+i);
//            Users user = new Users();
//            user.setUsername("a"+i);
//            user.setPassword("123");
//            user.setUserEmail("Chung"+i+"@gmail.com");
//            user.setUserType("employee");
//            userRepository.save(user);
//        }
        return userRepository.save(user);
    }
    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Users get() {

//        for(int i = 0; i<100000;i++){
//            LOGGER.info("Save lần thứ "+i);
//            Users user = new Users();
//            user.setUsername("a"+i);
//            user.setPassword("123");
//            user.setUserEmail("Chung"+i+"@gmail.com");
//            user.setUserType("employee");
//            userRepository.save(user);
//        }
        return userRepository.findOne(28329);
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

    @RequestMapping(value = WebURL.USER.MY_PROFILE, method = RequestMethod.GET)
    String myProfile(Model model){
        User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOGGER.info(u.getUsername());
        Users user = userService.getUserByUserName(u.getUsername());
        model.addAttribute("user",user);
        return "my-profile";
    }

}
