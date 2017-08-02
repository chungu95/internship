package project_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {

    @RequestMapping("/")
    public String test(){
        return "integrate";
    }

    @RequestMapping("/test")
    public String testa(){
        return "test";
    }
}
