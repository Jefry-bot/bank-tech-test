package com.bank.alert.notification.application.input.port;

import com.bank.alert.mail.domain.model.MailDomain;
import java.util.Map;

public interface ClientInputPort {
    MailDomain makeMail(Map<String, Object> client);
}
