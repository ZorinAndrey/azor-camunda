package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.azor.service.MailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * {@inheritDoc}.
 */

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    /**
     * {@inheritDoc}.
     */
    @Override
    public void sendMail(String toEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("AZorMailSender");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("New Tour");
        simpleMailMessage.setText("Hello, from AZor! Your holidays are started!\n" +
                                      LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        javaMailSender.send(simpleMailMessage);
    }
}
