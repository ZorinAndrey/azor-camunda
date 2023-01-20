package ru.azor.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * API exception response.
 */

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private String debugMessage;
}
