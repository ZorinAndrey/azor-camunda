package ru.azor.delegate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.azor.entity.Tour;
import ru.azor.entity.UserAccount;
import ru.azor.service.TourService;
import ru.azor.util.CommonConstants;

import java.util.List;

/**
 * Implementation service task with id 'Activity_find_tour'.
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class FindTourDelegate implements JavaDelegate {

    private final TourService tourService;

    @Override
    public void execute(DelegateExecution execution) {

        UserAccount userAccount = (UserAccount) execution.getVariable(CommonConstants.VARIABLE_USER_ACCOUNT);

        if (userAccount == null) {

            log.error(
                "Error: {}. {}", CommonConstants.USER_ACCOUNT_IS_NULL_ERROR,
                CommonConstants.USER_ACCOUNT_IS_NULL_ERROR_MESSAGE
            );

            throw new BpmnError(CommonConstants.USER_ACCOUNT_IS_NULL_ERROR);
        }

        log.debug("Get variable {}: {}", CommonConstants.VARIABLE_USER_ACCOUNT, userAccount);

        List<Tour> userTours = tourService.findAllToursByUserAccountId(userAccount.getId());

        execution.setVariable(CommonConstants.VARIABLE_USER_TOURS, userTours);

        log.debug("Set variable {}: {}", CommonConstants.VARIABLE_USER_TOURS, userTours);
    }
}
