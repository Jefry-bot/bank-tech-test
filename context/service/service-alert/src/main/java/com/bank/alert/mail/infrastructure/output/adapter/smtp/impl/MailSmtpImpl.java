package com.bank.alert.mail.infrastructure.output.adapter.smtp.impl;

import com.bank.alert.mail.application.output.port.MailOutputPort;
import com.bank.alert.mail.domain.exception.FailedMailException;
import com.bank.alert.mail.domain.model.MailDomain;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MailSmtpImpl implements MailOutputPort {
    private final JavaMailSender sender;
    private final JavaMailSenderImpl mailSender;

    @Override
    public void sendEmail(MailDomain mail) {
        try {
            sender.send(this.getMimeMessage(new MimeMessageHelper(mailSender.createMimeMessage()), mail));
        } catch (MessagingException exception){
            throw new FailedMailException();
        }
    }

    private MimeMessage getMimeMessage(MimeMessageHelper helper, MailDomain mail) throws MessagingException {
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getContent(), mail.getIsHtml());

        return helper.getMimeMessage();
    }
}
