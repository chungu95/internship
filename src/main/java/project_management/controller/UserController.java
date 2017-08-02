package project_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project_management.api.WebURL;
import project_management.repository.model.Users;
import project_management.service.service_interface.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value= WebURL.USER.LOGIN_PAGE, method = RequestMethod.GET)
    public String loginPage(){
        LOGGER.info("redirect to login page");
        return "login";
    }
}
