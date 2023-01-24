package ru.azor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import ru.azor.exception.UnAuthorizedException;
import ru.azor.service.ProcessService;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;

/**
 * RestController for process.
 */

@RestController
@RequestMapping("/process")
@RequiredArgsConstructor
public class ProcessController {

    private final ProcessService processService;
    private final HttpServletRequest httpServletRequest;

    private static final String AUTHORIZATION_HEADER_NAME = "Authorization";
    private static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";
    private static final String BAD_REQUEST_MESSAGE = "Request is invalid";
    private static final String INVALID_AUTHORIZATION_HEADER_MESSAGE = "Invalid authorization header";

    /**
     * Endpoint to start process.
     *
     * @return {@link ResponseEntity}
     */
    @Operation(summary = "Запуск процесса",
               responses = {@ApiResponse(description = "Успешный ответ", responseCode = "200")})
    @GetMapping("/")
    public ResponseEntity<Void> startProcess() {

        ServletWebRequest request = getRequest().orElseThrow(() -> new BadRequestException(BAD_REQUEST_MESSAGE));

        if (!isAuthorizationHeaderPresentAndBearerType(request)) {
            throw new UnAuthorizedException(INVALID_AUTHORIZATION_HEADER_MESSAGE);
        }

        String authorizationHeaderValue = getAuthorizationHeaderValue(request);

        processService.startProcess(authorizationHeaderValue);

        return ResponseEntity.ok().build();
    }

    /**
     * Method to get request.
     *
     * @return optional request
     */
    private Optional<ServletWebRequest> getRequest() {
        return Optional.of(new ServletWebRequest(httpServletRequest));
    }

    /**
     * Method to get authorization header value.
     *
     * @param request request
     * @return authorization header value
     */
    private String getAuthorizationHeaderValue(ServletWebRequest request) {
        return request.getHeader(AUTHORIZATION_HEADER_NAME);
    }

    /**
     * Method for check to authorization header is present and is bearer type.
     *
     * @param request request
     * @return boolean result
     */
    private boolean isAuthorizationHeaderPresentAndBearerType(ServletWebRequest request) {

        if (request.getHeader(AUTHORIZATION_HEADER_NAME) == null) {
            return false;
        }

        return request.getHeader(AUTHORIZATION_HEADER_NAME).startsWith(AUTHORIZATION_HEADER_PREFIX);
    }
}
