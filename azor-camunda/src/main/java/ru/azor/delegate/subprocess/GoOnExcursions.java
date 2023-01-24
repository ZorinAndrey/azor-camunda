package ru.azor.delegate.subprocess;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Implementation service task with id 'Activity_go_on_excursions'.
 */

@Component
@Slf4j
public class GoOnExcursions implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        log.info("Go on excursions");
    }
}
