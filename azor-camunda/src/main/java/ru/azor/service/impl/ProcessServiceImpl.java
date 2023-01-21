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

    private final RuntimeService runtimeService;
    private static final String PROCESS_DEFINITION_KEY = "azor-camunda-process";

    /**
     * {@inheritDoc}
     */
    @Override
    public void completeProcess() {

        runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);

        log.debug("Process completed with definition key {}", PROCESS_DEFINITION_KEY);
    }
}
