package ru.azor.mapper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;
import ru.azor.util.CommonConstants;

@Component
public class SetVariableToScopeMappingDelegate implements DelegateVariableMapping {
    @Override
    public void mapInputVariables(DelegateExecution superExecution, VariableMap subVariables) {
        superExecution.setVariable(CommonConstants.VARIABLE_TO_CHANGE,CommonConstants.VARIABLE_TO_CHANGE_VALUE,
                                   "Activity_second");
    }

    @Override
    public void mapOutputVariables(DelegateExecution superExecution, VariableScope subInstance) {
    }
}