package com.Saas.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Working ✅";}

    @GetMapping("/user")
    public String user(HttpServletRequest req) {
        return "Hello User: " + req.getAttribute("email");
    }

    @GetMapping("/admin")
    public String admin(HttpServletRequest req) {
        String role = (String) req.getAttribute("role");

        if (!"ADMIN".equals(role)) {
            throw new RuntimeException("Access Denied!");
        }

        return "Welcome Admin";
    }


}
