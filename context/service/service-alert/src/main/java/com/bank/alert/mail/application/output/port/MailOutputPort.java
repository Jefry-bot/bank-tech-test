package com.bank.alert.mail.application.output.port;

import com.bank.alert.mail.domain.model.MailDomain;

public interface MailOutputPort {
    void sendEmail(MailDomain mail);
}
