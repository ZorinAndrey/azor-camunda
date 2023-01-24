package ru.azor.delegate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.azor.entity.UserAccount;
import ru.azor.service.MailService;
import ru.azor.util.CommonConstants;

/**
 * Implementation service task with id 'Activity_send_email'.
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class SendEmailDelegate implements JavaDelegate {

    private final MailService mailService;

    @Override
    public void execute(DelegateExecution execution) {

        try {
            UserAccount userAccount = (UserAccount) execution.getVariable(CommonConstants.VARIABLE_USER_ACCOUNT);

            log.debug("Get variable {}: {}", CommonConstants.VARIABLE_USER_ACCOUNT, userAccount);

            mailService.sendMail(userAccount.getEmail());

            log.debug("Send mail to {}", userAccount.getEmail());

        } catch (Exception exception) {

            log.error("Error: {}. {}", CommonConstants.SANDING_MAIL_ERROR, "Error while sanding mail");

            throw new BpmnError(CommonConstants.SANDING_MAIL_ERROR);
        }
    }
}
