package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.azor.model.UserPayloadJsonRoot;
import ru.azor.service.KeyCloakService;
import ru.azor.util.CommonConstants;

/**
 * {@inheritDoc}
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class KeyCloakServiceImpl implements KeyCloakService {

    private final WebClient keyCloakWebClient;

    /**
     * {@inheritDoc}
     */
    public UserPayloadJsonRoot validateAccessTokenAndGetUserPayload(String authorizationHeaderValue) {
        return keyCloakWebClient.get().headers(header -> {
            header.add(CommonConstants.CONTENT_TYPE_HEADER_NAME, CommonConstants.CONTENT_TYPE_HEADER_VALUE);
            header.add(CommonConstants.AUTHORIZATION_HEADER_NAME, authorizationHeaderValue);
        }).retrieve().bodyToMono(UserPayloadJsonRoot.class).block();
    }
}
