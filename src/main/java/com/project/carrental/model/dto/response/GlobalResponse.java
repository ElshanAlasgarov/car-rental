package com.project.carrental.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class GlobalResponse {

    private UUID requestId;
    private String errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;

}
