package com.nttdata.bootcamp57.oauthservice.dto;

import lombok.Data;

@Data
public class LoginResponse {
    String token;
    String type;
    Integer timeout;

    public LoginResponse(String token, String type, Integer timeout) {
        this.token = token;
        this.type = type;
        this.timeout = timeout;
    }

}
