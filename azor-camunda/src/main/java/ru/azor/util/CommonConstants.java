package ru.azor.util;

import java.math.BigDecimal;

/**
 * Constants for application.
 */

public class CommonConstants {

    private CommonConstants() {
    }

    public static final String VARIABLE_AUTHORIZATION_HEADER_VALUE = "authorizationHeaderValue";
    public static final String VARIABLE_USER_ACCOUNT = "userAccount";
    public static final String VARIABLE_USERNAME = "username";
    public static final String VARIABLE_USER_EMAIL = "email";
    public static final String VARIABLE_USER_TOURS = "userTours";
    public static final String IS_NOT_ENOUGH_RICH_ERROR = "isNotEnoughRich";
    public static final String CHECK_TOKEN_ERROR = "checkTokenError";
    public static final String USERNAME_IS_NULL_ERROR = "usernameIsNullError";
    public static final String USER_ACCOUNT_IS_NULL_ERROR = "userAccountIsNullError";
    public static final String SAVE_USER_ACCOUNT_ERROR = "saveUserAccountError";
    public static final String SAVE_TOUR_ERROR = "saveTourError";
    public static final String SANDING_MAIL_ERROR = "sendingMailError";
    public static final String USERNAME_IS_NULL_ERROR_MESSAGE = "Username is null";
    public static final String USER_ACCOUNT_IS_NULL_ERROR_MESSAGE = "User account is null";
    public static final String CONTENT_TYPE_HEADER_VALUE = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
    public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
    public static final String SIGNAL_START_PROCESS_NAME = "Signal_start_process";
    public static final String PROCESS_DEFINITION_KEY = "azor-camunda-process";
    public static final BigDecimal ENOUGH_MONEY = BigDecimal.valueOf(1000000);
}
