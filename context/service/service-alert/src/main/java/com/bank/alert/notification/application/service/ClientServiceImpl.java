package com.bank.alert.notification.application.service;

import com.bank.alert.mail.domain.model.MailDomain;
import com.bank.alert.notification.application.input.port.ClientInputPort;
import com.bank.alert.template.application.input.port.TemplateInputPort;
import java.util.Map;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientInputPort {
  @Value("${mail.templates.client}")
  private String templateName;

  private final TemplateInputPort templateInputPort;

  @Override
  public MailDomain makeMail(Map<String, Object> notification) {
    return MailDomain.init()
        .subject("Tu transacción a sido aprobada")
        .to(Optional.ofNullable(notification)
                .map(n -> (Map<String, Object>) n.get("account"))
                .map(a -> (Map<String, Object>) a.get("client"))
                .map(c -> (String) c.get("email"))
                .orElse(null))
        .content(
            templateInputPort.processTemplate(
                templateName,
                    notification))
        .isHtml(true)
        .build();
  }
}
