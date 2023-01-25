package ru.azor.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;
import ru.azor.util.CommonConstants;


/**
 * Execution listener for end process.
 */

@Component
@Slf4j
public class EndProcessListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) {

        String variableToChange = (String) execution.getVariable(CommonConstants.VARIABLE_TO_CHANGE);

        log.info("VariableToChange in the end of parent process: " + variableToChange);

        log.info("Process completed");
    }
}
