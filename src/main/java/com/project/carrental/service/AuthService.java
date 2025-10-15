package com.project.carrental.service;

import com.project.carrental.model.dto.request.LoginRequest;
import com.project.carrental.model.dto.request.RegisterRequest;
import com.project.carrental.model.dto.response.AuthResponse;

public interface AuthService {

    void register(RegisterRequest registerRequest);

    AuthResponse login(LoginRequest loginRequest);
}
