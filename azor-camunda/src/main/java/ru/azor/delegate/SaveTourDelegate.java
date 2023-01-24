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
 * Implementation service task with id 'Activity_save_tour'.
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class SaveTourDelegate implements JavaDelegate {

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

        Tour savedTour;

        try {
            savedTour = tourService.save(Tour.builder().userAccount(userAccount).build());

            log.debug("Save {} ", savedTour);

            execution.setVariable(CommonConstants.VARIABLE_USER_TOURS, List.of(savedTour));

            log.debug("Set variable {}: {}", CommonConstants.VARIABLE_USER_TOURS, savedTour);
        } catch (Exception exception) {

            log.error("Error: {}. {}", CommonConstants.SAVE_TOUR_ERROR, "Error while saving tour");

            throw new BpmnError(CommonConstants.SAVE_TOUR_ERROR);
        }
    }
}
