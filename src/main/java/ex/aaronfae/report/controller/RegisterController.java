package ex.aaronfae.report.controller;

import ex.aaronfae.report.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(Users user) {
        return "register";
    }
}
