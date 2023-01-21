package ru.azor.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

/**
 * Execution listener for start process.
 */

@Component
@Slf4j
public class StartExecutionListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) {
        log.info("Process started");
    }
}
