package com.project.carrental.exception;

public class NoActiveRentalException extends RuntimeException {
    public NoActiveRentalException(String message) {
        super(message);
    }
}
