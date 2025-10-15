package com.project.carrental.mapper;

import com.project.carrental.domain.entity.User;
import com.project.carrental.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(String.valueOf(user.getRole()))
                .build();
    }
}
