package com.lalith.auction.advice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        int statusCode,
        String message,
        String details,
        LocalDateTime timestamp,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Map<String,String> validationsErrors
) {
}
