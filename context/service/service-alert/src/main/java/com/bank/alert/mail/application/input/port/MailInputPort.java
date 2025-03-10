package com.bank.alert.mail.application.input.port;

import com.bank.alert.mail.domain.model.MailDomain;

public interface MailInputPort {
    void sendEmail(MailDomain mail);
}
