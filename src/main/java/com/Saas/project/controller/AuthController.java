package com.Saas.project.controller;

import com.Saas.project.dto.JoinReq;
import com.Saas.project.dto.LoginReq;
import com.Saas.project.dto.RegisterReq;
import com.Saas.project.entity.User;
import com.Saas.project.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinReq req) {
        User user = authService.joinTenant(req);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterReq request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq req) {
        return ResponseEntity.ok(authService.login(req));
    }
}