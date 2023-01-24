package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;
import ru.azor.service.ProcessService;

/**
 * {@inheritDoc}
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private static final String AUTHORIZATION_HEADER_VALUE = "authorizationHeaderValue";
    private static final String ACTIVITY_CHECK_TOKEN_EXECUTION_ID = "Activity_check_token";
    private static final String PROCESS_DEFINITION_KEY = "azor-camunda-process";
    private final RuntimeService runtimeService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void startProcess(String authorizationHeaderValue) {

        runtimeService.signalEventReceived("Signal_start_process");

        log.debug("Process started in service with definition key {}", PROCESS_DEFINITION_KEY);
    }
}
