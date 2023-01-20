package ru.azor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.azor.service.ProcessService;

/**
 * RestController for process.
 */

@RestController
@RequestMapping("/process")
@RequiredArgsConstructor
public class ProcessController {

    private final ProcessService processService;

    /**
     * Endpoint to start process.
     *
     * @return {@link ResponseEntity}
     */
    @Operation(summary = "Запуск процесса",
               responses = {@ApiResponse(description = "Успешный ответ", responseCode = "200")})
    @GetMapping("/")
    public ResponseEntity<Void> startProcess() {

        processService.completeProcess();

        return ResponseEntity.ok().build();
    }
}
