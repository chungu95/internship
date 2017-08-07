package project_management.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project_management.api.WebURL;

@Controller
public class LoginController {
    Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    @RequestMapping(value = WebURL.USER.LOGIN_PAGE, method = RequestMethod.GET)
    public String loginPage() {
        LOGGER.info("REDIRECT TO LOGIN PAGE");
        return "login";
    }
}
