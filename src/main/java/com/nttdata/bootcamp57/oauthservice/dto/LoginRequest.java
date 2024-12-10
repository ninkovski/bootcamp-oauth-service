package com.nttdata.bootcamp57.oauthservice.dto;


import lombok.Data;
@Data
public class LoginRequest {
    private String username;
    private String password;
}
