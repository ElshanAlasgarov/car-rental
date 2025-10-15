package com.project.carrental.model.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCode {
    public static final String ALREADY_EXISTS = "ALREADY_EXISTS";
    public static final String NOT_FOUND = "NOT_FOUND";
    public static final String BAD_REQUEST = "BAD_REQUEST";
    public static final String UNAUTHORIZED = "UNAUTHORIZED";
    public static final String FORBIDDEN = "FORBIDDEN";
    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";


}
