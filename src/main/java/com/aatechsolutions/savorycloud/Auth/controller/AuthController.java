package com.aatechsolutions.savorycloud.Auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatechsolutions.savorycloud.Auth.dto.RegisterDTO;
import com.aatechsolutions.savorycloud.Auth.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register/admin")
    public String register(@RequestBody RegisterDTO registerDTO) {
        authService.register(registerDTO);
        return "Registro exitoso";
    }
    
    
}
