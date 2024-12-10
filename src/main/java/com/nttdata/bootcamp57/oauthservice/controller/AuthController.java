package com.nttdata.bootcamp57.oauthservice.controller;

import com.nttdata.bootcamp57.oauthservice.dto.LoginRequest;
import com.nttdata.bootcamp57.oauthservice.dto.LoginResponse;
import com.nttdata.bootcamp57.oauthservice.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.authenticateAndGenerateToken(loginRequest);
    }
}
