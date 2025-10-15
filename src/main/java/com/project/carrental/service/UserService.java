package com.project.carrental.service;

import com.project.carrental.domain.entity.User;
import com.project.carrental.model.dto.response.UserResponseDto;
import com.project.carrental.model.enums.Role;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllUsers(String role);

    User getUserByEmail(String email);
}
