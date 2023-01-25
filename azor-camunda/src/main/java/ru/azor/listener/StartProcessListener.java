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
        execution.setVariable(CommonConstants.VARIABLE_TO_CHANGE_FIRST, CommonConstants.VARIABLE_TO_CHANGE_VALUE_FIRST);

        log.info(
            "Set variable {} value: {}", CommonConstants.VARIABLE_TO_CHANGE_FIRST,
            CommonConstants.VARIABLE_TO_CHANGE_VALUE_FIRST
        );

        execution.setVariable(
            CommonConstants.VARIABLE_TO_CHANGE_SECOND, CommonConstants.VARIABLE_TO_CHANGE_VALUE_SECOND);

        log.info(
            "Set variable {} value: {}", CommonConstants.VARIABLE_TO_CHANGE_SECOND,
            CommonConstants.VARIABLE_TO_CHANGE_VALUE_SECOND
        );
    }
}
