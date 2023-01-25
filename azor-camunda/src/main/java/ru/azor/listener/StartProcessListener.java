package ru.azor.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;
import ru.azor.util.CommonConstants;

/**
 * Execution listener for start process.
 */

@Component
@Slf4j
public class StartProcessListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) {
        execution.setVariable(CommonConstants.VARIABLE_TO_CHANGE, CommonConstants.VARIABLE_TO_CHANGE_VALUE);
    }
}
