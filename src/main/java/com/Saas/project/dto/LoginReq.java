package com.Saas.project.dto;

import lombok.Data;

@Data
public class LoginReq {
    private String slug;
    private String email;
    private String password;
}
