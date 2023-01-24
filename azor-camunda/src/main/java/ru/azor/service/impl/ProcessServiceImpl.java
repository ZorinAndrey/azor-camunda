package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;
import ru.azor.service.ProcessService;
import ru.azor.util.CommonConstants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@inheritDoc}
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private final RuntimeService runtimeService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void startProcess(String authorizationHeaderValue) {

        Map<String, Object> variables = new ConcurrentHashMap<>();

        variables.put(CommonConstants.VARIABLE_AUTHORIZATION_HEADER_VALUE, authorizationHeaderValue);

        log.debug("Set variable {}", CommonConstants.VARIABLE_AUTHORIZATION_HEADER_VALUE);

        runtimeService.signalEventReceived(CommonConstants.SIGNAL_START_PROCESS_NAME, variables);

        log.debug("Process with definition key {} started by signal start event {}",
                  CommonConstants.PROCESS_DEFINITION_KEY, CommonConstants.SIGNAL_START_PROCESS_NAME
        );
    }
}
