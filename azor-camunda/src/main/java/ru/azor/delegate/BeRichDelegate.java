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

import java.math.BigDecimal;

/**
 * Implementation service task with id 'Activity_be_rich'.
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class BeRichDelegate implements JavaDelegate {

    private final UserAccountService userAccountService;

    @Override
    public void execute(DelegateExecution execution) {

        UserAccount userAccount = (UserAccount) execution.getVariable(CommonConstants.VARIABLE_USER_ACCOUNT);

        log.debug("Get variable {}: {}", CommonConstants.VARIABLE_USER_ACCOUNT, userAccount);

        BigDecimal userAccountMoney = userAccount.getMoney();

        if (userAccountMoney.compareTo(CommonConstants.ENOUGH_MONEY) < 0) {
            userAccountMoney = userAccountMoney.add(CommonConstants.ENOUGH_MONEY);
            userAccount.setMoney(userAccountMoney);

            userAccount = userAccountService.save(userAccount);

            log.debug("Save {} ", userAccount);
        }

        if (userAccount.getMoney().compareTo(CommonConstants.ENOUGH_MONEY) < 0) {

            log.error("User {} is not enough rich", userAccount.getUsername());

            throw new BpmnError(CommonConstants.IS_NOT_ENOUGH_RICH_ERROR);
        }

        execution.setVariable(CommonConstants.VARIABLE_USER_ACCOUNT, userAccount);

        log.debug("Set variable {}: {}", CommonConstants.VARIABLE_USER_ACCOUNT, userAccount);
    }
}
