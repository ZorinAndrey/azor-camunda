package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.azor.model.UserPayloadJsonRoot;
import ru.azor.service.KeyCloakService;

/**
 * {@inheritDoc}
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class KeyCloakServiceImpl implements KeyCloakService {

    private final WebClient keyCloakWebClient;

    private static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
    private static final String CONTENT_TYPE_HEADER_VALUE = "application/x-www-form-urlencoded";
    private static final String AUTHORIZATION_HEADER_NAME = "Authorization";

    /**
     * {@inheritDoc}
     */
    public UserPayloadJsonRoot validateAccessTokenAndGetUserPayload(String authorizationHeaderValue) {
        return keyCloakWebClient.get().headers(header -> {
            header.add(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE);
            header.add(AUTHORIZATION_HEADER_NAME, authorizationHeaderValue);
        }).retrieve().bodyToMono(UserPayloadJsonRoot.class).block();
    }
}
