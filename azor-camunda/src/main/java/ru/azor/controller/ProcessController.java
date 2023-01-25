package ru.azor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.azor.model.SimpleEvent;
import ru.azor.service.KafkaProducerService;

/**
 * RestController for process.
 */

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class ProcessController {

    private final KafkaProducerService kafkaProducerService;

    /**
     * Endpoint to start process.
     *
     * @return {@link ResponseEntity}
     */
    @Operation(summary = "Событие для процесса",
               responses = {@ApiResponse(description = "Успешный ответ", responseCode = "200")})
    @PostMapping("/")
    public ResponseEntity<Void> sendEvent(@RequestBody SimpleEvent simpleEvent) {

        kafkaProducerService.sendEvent(simpleEvent);

        return ResponseEntity.ok().build();
    }
}
