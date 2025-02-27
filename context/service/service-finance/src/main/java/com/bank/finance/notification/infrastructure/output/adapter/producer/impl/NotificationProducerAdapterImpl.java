package com.bank.finance.notification.infrastructure.output.adapter.producer.impl;

import com.bank.finance.notification.application.output.port.NotificationOutputPort;
import com.bank.finance.notification.infrastructure.output.adapter.producer.configuration.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import static com.bank.common.utilities.JsonUtility.toJson;

@Producer
@RequiredArgsConstructor
public class NotificationProducerAdapterImpl implements NotificationOutputPort {
  private final KafkaTemplate<String, Object> kafkaTemplate;

  @Value("${spring.kafka.template.default-topic}")
  private String topic;

  @Override
  public void send(String message) {
    kafkaTemplate.send(topic, toJson(message));
  }
}
