package ru.azor.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Implementation service task of process.
 */

@Component
@Slf4j
public class SimpleDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        log.info("Process completed");
    }
}
