package project_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class test {
    private static final Logger LOGGER = Logger.getLogger(test.class.getName());

    @RequestMapping("/")
    public String test() {
        LOGGER.info("REDIRECT TO HOME");
        return "integrate";
    }

    @RequestMapping("/403")
    public String testa() {
        return "403";
    }

}
