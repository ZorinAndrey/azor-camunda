package ru.azor.util;

/**
 * Class of constants.
 */

public class CommonConstants {

    private CommonConstants() {}

    public static final String KAFKA_TOPIC = "azor-topic";
    public static final String KAFKA_GROUP_ID = "azor-group";

    public static final String START_PARENT_PROCESS_MESSAGE_EVENT = "Message_start_main";
    public static final String START_FIRST_SUB_PROCESS_MESSAGE_EVENT = "Message_start_first_sub";

    public static final String VARIABLE_TO_CHANGE_FIRST = "variableToChangeFirst";
    public static final String VARIABLE_TO_CHANGE_VALUE_FIRST = "CommonFirst";
    public static final String VARIABLE_TO_CHANGE_SECOND = "variableToChangeSecond";
    public static final String VARIABLE_TO_CHANGE_VALUE_SECOND = "CommonSecond";
}
