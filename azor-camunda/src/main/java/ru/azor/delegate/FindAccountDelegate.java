package ru.azor.delegate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.azor.entity.UserAccount;
import ru.azor.service.UserAccountService;
import ru.azor.util.CommonConstants;

/**
 * Implementation service task with id 'Activity_find_account'.
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class FindAccountDelegate implements JavaDelegate {

    private final UserAccountService userAccountService;

    @Override
    public void execute(DelegateExecution execution) {

        String username = (String) execution.getVariable(CommonConstants.VARIABLE_USERNAME);

        if (username == null) {

            log.error(
                "Error: {}. {}", CommonConstants.USERNAME_IS_NULL_ERROR,
                CommonConstants.USERNAME_IS_NULL_ERROR_MESSAGE
            );

            throw new BpmnError(CommonConstants.USERNAME_IS_NULL_ERROR);
        }

        log.debug("Get variable {}: {}", CommonConstants.VARIABLE_USERNAME, username);

        UserAccount userAccount = userAccountService.findByUsername(username);

        execution.setVariable(CommonConstants.VARIABLE_USER_ACCOUNT, userAccount);

        log.debug("Set variable {}: {}", CommonConstants.VARIABLE_USER_ACCOUNT, userAccount);
    }
}
