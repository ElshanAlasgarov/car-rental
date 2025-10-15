package com.project.carrental.service.impl;

import com.project.carrental.domain.entity.User;
import com.project.carrental.domain.repository.UserRepository;
import com.project.carrental.exception.AlreadyExistsException;
import com.project.carrental.exception.NotFoundException;
import com.project.carrental.model.dto.request.LoginRequest;
import com.project.carrental.model.dto.request.RegisterRequest;
import com.project.carrental.model.dto.response.AuthResponse;
import com.project.carrental.security.JwtService;
import com.project.carrental.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail()) ||
                userRepository.existsByPhoneNumber(registerRequest.getPhoneNumber())) {
            throw new AlreadyExistsException("User already exists with email: " + registerRequest.getEmail()
                    + " or phone number: " + registerRequest.getPhoneNumber());
        }
        userRepository.save(User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(registerRequest.getRole())
                .build());

    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword())
        );

        var user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new NotFoundException("User not found"));

        String token = jwtService.generateToken(user);

        return new AuthResponse(token);
    }
}
