package com.bank.alert.notification.application.service;

import com.bank.alert.mail.application.input.port.MailInputPort;
import com.bank.alert.notification.application.input.port.ClientInputPort;
import com.bank.alert.notification.application.input.port.NotificationInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationInputPort {
  private final MailInputPort mailInputPort;
  private final ClientInputPort clientInputPort;

  @Override
  public void clientProcessNotification(Map<String, Object> notification) {
    mailInputPort.sendEmail(clientInputPort.makeMail(notification));
  }
}
