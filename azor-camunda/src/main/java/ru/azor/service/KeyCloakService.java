package ru.azor.service;

import ru.azor.model.UserPayloadJsonRoot;

/**
 * KeyCloak Call Service.
 */

public interface KeyCloakService {

    /**
     * Method for validate access token and get user payload.
     *
     * @param authorizationHeaderValue access token
     * @return user payload
     */
    UserPayloadJsonRoot validateAccessTokenAndGetUserPayload(String authorizationHeaderValue);
}
