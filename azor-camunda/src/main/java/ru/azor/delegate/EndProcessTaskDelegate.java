package ru.azor.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


/**
 * Execution for end process.
 */

@Component
@Slf4j
public class EndProcessTaskDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        log.info("Process ended");
    }
}
