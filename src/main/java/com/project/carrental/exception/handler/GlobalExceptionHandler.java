package com.project.carrental.exception.handler;

import com.project.carrental.exception.AlreadyExistsException;
import com.project.carrental.exception.NoActiveRentalException;
import com.project.carrental.exception.NotFoundException;
import com.project.carrental.exception.UnauthorizedExceptionHandler;
import com.project.carrental.model.constant.ErrorCode;
import com.project.carrental.model.dto.response.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<GlobalResponse> alreadyExistsExceptionHandler(RuntimeException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalResponse.builder()
                .requestId(UUID.randomUUID())
                .errorCode(ErrorCode.ALREADY_EXISTS)
                .errorMessage(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GlobalResponse> notFoundExceptionHandler(RuntimeException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(GlobalResponse.builder()
                .requestId(UUID.randomUUID())
                .errorCode(ErrorCode.NOT_FOUND)
                .errorMessage(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    @ExceptionHandler(UnauthorizedExceptionHandler.class)
    public ResponseEntity<GlobalResponse> unauthorizedExceptionHandler(RuntimeException e) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(GlobalResponse.builder()
                .requestId(UUID.randomUUID())
                .errorCode(ErrorCode.UNAUTHORIZED)
                .errorMessage(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    @ExceptionHandler(NoActiveRentalException.class)
    public ResponseEntity<GlobalResponse> noActiveRentalExceptionHandler(RuntimeException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GlobalResponse.builder()
                .requestId(UUID.randomUUID())
                .errorCode(ErrorCode.BAD_REQUEST)
                .errorMessage(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }
}
