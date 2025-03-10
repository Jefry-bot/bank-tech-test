package com.bank.alert.mail.application.service;

import com.bank.alert.mail.application.input.port.MailInputPort;
import com.bank.alert.mail.application.output.port.MailOutputPort;
import com.bank.alert.mail.domain.model.MailDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailInputPort {
    private final MailOutputPort outputPort;

    @Override
    public void sendEmail(MailDomain mail) {
        this.outputPort.sendEmail(mail);
    }
}
