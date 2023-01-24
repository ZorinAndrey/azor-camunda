package ru.azor.service;

/**
 * Service for mail sending.
 */

public interface MailService {

    /**
     * Method to send mail.
     */
    void sendMail(String toEmail);
}
