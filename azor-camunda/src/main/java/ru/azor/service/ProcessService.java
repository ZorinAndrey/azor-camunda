package ru.azor.service;

/**
 * Service of process.
 */

public interface ProcessService {

    /**
     * Method to pass the event to the process.
     *
     * @param event incoming event
     */
    void passTheEventToTheProcess(String event);
}
