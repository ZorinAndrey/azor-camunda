package ru.azor.delegate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.azor.model.UserPayloadJsonRoot;
import ru.azor.service.KeyCloakService;
import ru.azor.util.CommonConstants;

/**
 * Implementation service task with id 'Activity_check_token'.
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class CheckAccessTokenByKeyCloak implements JavaDelegate {

    private final KeyCloakService keyCloakService;

    @Override
    public void execute(DelegateExecution execution) {

        String authorizationHeaderValue =
            (String) execution.getVariable(CommonConstants.VARIABLE_AUTHORIZATION_HEADER_VALUE);
        log.debug("Get variable {}: {}", CommonConstants.VARIABLE_AUTHORIZATION_HEADER_VALUE, authorizationHeaderValue);

        UserPayloadJsonRoot userPayloadJsonRoot;
        try {
            userPayloadJsonRoot = keyCloakService.validateAccessTokenAndGetUserPayload(authorizationHeaderValue);

            log.debug("Validate access token and get user payload {}", userPayloadJsonRoot);

            String username = userPayloadJsonRoot.getUsername();
            String userEmail = userPayloadJsonRoot.getEmail();

            execution.setVariable(CommonConstants.VARIABLE_USERNAME, username);
            execution.setVariable(CommonConstants.VARIABLE_USER_EMAIL, userEmail);

            log.debug("Set variables: {} and {}", username, userEmail);
        } catch (Exception exception) {
            log.error("Error: {}. {}", CommonConstants.CHECK_TOKEN_ERROR, exception.getMessage());

            throw new BpmnError(CommonConstants.CHECK_TOKEN_ERROR);
        }
    }
}
