package com.example.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {


    @GetMapping("/")
    public String home() {
        return "home"; // вернёт home.html из templates
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
