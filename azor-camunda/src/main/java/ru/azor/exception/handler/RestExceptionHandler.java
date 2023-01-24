package ru.azor.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.AuthenticationException;
import org.camunda.bpm.engine.ProcessEngineException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import ru.azor.exception.ExceptionResponse;
import ru.azor.exception.UnAuthorizedException;

import javax.ws.rs.BadRequestException;

/**
 * Exception handler for controller.
 */

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * BadRequestException handler.
     *
     * @param exception input exception
     * @param request   incoming request
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<Object> handleBadRequestException(BadRequestException exception, WebRequest request) {
        return new ResponseEntity<>(basicActions(request, "BadRequestException", exception.getMessage()),
                                    HttpStatus.BAD_REQUEST
        );
    }

    /**
     * UnAuthorizedException handler.
     *
     * @param exception input exception
     * @param request   incoming request
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(UnAuthorizedException.class)
    ResponseEntity<Object> handleUnAuthorizedException(UnAuthorizedException exception, WebRequest request) {
        return new ResponseEntity<>(basicActions(request, "UnAuthorizedException", exception.getMessage()),
                                    HttpStatus.UNAUTHORIZED
        );
    }

    /**
     * ProcessEngineException handler.
     *
     * @param exception input exception
     * @param request   incoming request
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(ProcessEngineException.class)
    ResponseEntity<Object> handleProcessEngineException(ProcessEngineException exception, WebRequest request) {
        return new ResponseEntity<>(basicActions(request, "ProcessEngineException", exception.getMessage()),
                                    HttpStatus.SERVICE_UNAVAILABLE
        );
    }

    /**
     * AuthenticationException handler.
     *
     * @param exception input exception
     * @param request   incoming request
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(AuthenticationException.class)
    ResponseEntity<Object> handleAuthenticationException(AuthenticationException exception, WebRequest request) {
        return new ResponseEntity<>(basicActions(request, "AuthenticationException", exception.getMessage()),
                                    HttpStatus.SERVICE_UNAVAILABLE
        );
    }

    /**
     * Default handler.
     *
     * @param exception input exception
     * @param request   incoming request
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        return new ResponseEntity<>(basicActions(request, "Some exception", exception.getMessage()),
                                    HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    /**
     * Build the response {@link ExceptionResponse}.
     *
     * @param request      incoming request
     * @param message      exception message
     * @param debugMessage exception debug message
     * @return {@link ResponseEntity}
     */
    private ExceptionResponse basicActions(WebRequest request, String message, String debugMessage) {
        log.error("Request URL : {}, Exception : {}", ((ServletWebRequest) request).getRequest().getRequestURI(),
                  debugMessage
        );
        return new ExceptionResponse(message, debugMessage);
    }
}
