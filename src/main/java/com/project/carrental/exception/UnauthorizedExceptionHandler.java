package com.project.carrental.exception;

public class UnauthorizedExceptionHandler extends RuntimeException {
    public UnauthorizedExceptionHandler(String message) {
        super(message);
    }
}
