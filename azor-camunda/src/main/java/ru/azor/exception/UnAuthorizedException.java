package ru.azor.exception;

/**
 * Exception to unauthorized request.
 */

public class UnAuthorizedException extends RuntimeException {

    public UnAuthorizedException(String message) {
        super(message);
    }
}
