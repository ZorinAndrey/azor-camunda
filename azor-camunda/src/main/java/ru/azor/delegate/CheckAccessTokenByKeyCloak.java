package ru.azor.delegate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.azor.model.UserPayloadJsonRoot;
import ru.azor.service.KeyCloakService;

/**
 * Implementation service task with id 'Activity_check_token'.
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class CheckAccessTokenByKeyCloak implements JavaDelegate {

    private final KeyCloakService keyCloakService;

    private static final String CHECK_TOKEN_ERROR = "checkTokenError";
    private static final String VARIABLE_NAME_USERNAME = "username";
    private static final String AUTHORIZATION_HEADER_VALUE = "authorizationHeaderValue";

    @Override
    public void execute(DelegateExecution execution) {

        String authorizationHeaderValue = (String) execution.getVariable(AUTHORIZATION_HEADER_VALUE);
        System.out.println("Check " + authorizationHeaderValue);
        UserPayloadJsonRoot userPayloadJsonRoot;
        try {
            userPayloadJsonRoot = keyCloakService.validateAccessTokenAndGetUserPayload(authorizationHeaderValue);
        } catch (Exception exception) {
            throw new BpmnError(CHECK_TOKEN_ERROR);
        }

        String username = userPayloadJsonRoot.getUsername();

        System.out.println(username);
        execution.setVariable(VARIABLE_NAME_USERNAME, username);
    }
}
