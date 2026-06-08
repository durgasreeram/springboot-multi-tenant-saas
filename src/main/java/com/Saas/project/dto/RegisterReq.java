package com.Saas.project.dto;

import lombok.Data;

@Data
public class RegisterReq {

    private String CompanyName;
    private String slug;
    private String email;
    private String password;

}
