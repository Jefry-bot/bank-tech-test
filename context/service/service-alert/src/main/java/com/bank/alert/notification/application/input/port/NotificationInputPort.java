package com.bank.alert.notification.application.input.port;

import java.util.Map;

public interface NotificationInputPort {
  void clientProcessNotification(Map<String, Object> notification);
}
