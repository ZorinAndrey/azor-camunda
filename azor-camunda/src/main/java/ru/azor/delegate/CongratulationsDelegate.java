package ru.azor.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Implementation service task with id 'Activity_congratulations'.
 */

@Component
@Slf4j
public class CongratulationsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        log.info("Congratulations!");
    }
}
