package com.project.carrental.service.impl;

import com.project.carrental.domain.entity.User;
import com.project.carrental.domain.repository.UserRepository;
import com.project.carrental.exception.NotFoundException;
import com.project.carrental.mapper.UserMapper;
import com.project.carrental.model.dto.response.UserResponseDto;
import com.project.carrental.model.enums.Role;
import com.project.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAllUsers(String role) {
        if (!userRepository.existsByRole(Role.valueOf(role.toUpperCase()))) {
            throw new NotFoundException("No users found with role: " + role);
        }
        return userRepository.findByRole(Role.valueOf(role.toUpperCase())).stream()
                .map(user -> userMapper.toDto(user))
                .toList();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found"));
    }
}
