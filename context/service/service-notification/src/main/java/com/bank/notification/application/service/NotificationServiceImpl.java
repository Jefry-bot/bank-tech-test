package com.bank.notification.application.service;

import com.bank.common.utilities.JsonUtility;
import com.bank.notification.application.input.port.NotificationInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationInputPort {

  @Override
  public void processNotification(Object notification) {
    log.info("Received event ... with {}", JsonUtility.toStringFormat(notification));
  }
}
