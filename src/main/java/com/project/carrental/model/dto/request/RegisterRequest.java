package com.project.carrental.model.dto.request;

import com.project.carrental.model.enums.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private Role role;
}
