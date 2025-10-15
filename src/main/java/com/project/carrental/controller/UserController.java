package com.project.carrental.controller;

import com.project.carrental.domain.entity.User;
import com.project.carrental.model.dto.response.UserResponseDto;
import com.project.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/by-role")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(
            @RequestParam String role
    ) {
        return ResponseEntity.ok(userService.getAllUsers(role));
    }
}
