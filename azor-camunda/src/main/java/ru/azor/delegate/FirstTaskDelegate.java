package ru.azor.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.azor.util.CommonConstants;

/**
 * Implementation for task 'Activity_first_task'.
 */

@Component
@Slf4j
public class FirstTaskDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        log.info("First sub process service task");

        String variableToChange = (String) execution.getVariable(CommonConstants.VARIABLE_TO_CHANGE);
        variableToChange = variableToChange.concat("_1");
        execution.setVariable(CommonConstants.VARIABLE_TO_CHANGE, variableToChange);

        log.info("Changed variable in 'Activity_first': " + variableToChange);
    }
}
