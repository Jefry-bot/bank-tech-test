package com.bank.notification.infrastructure.input.adapter.consumer.impl;

import com.bank.notification.application.input.port.NotificationInputPort;
import com.bank.notification.infrastructure.input.adapter.consumer.configuration.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Consumer
@RequiredArgsConstructor
public class NotificationConsumer {

  private final NotificationInputPort inputPort;

  @KafkaListener(
      topics = "${spring.kafka.template.default-topic}",
      groupId = "${spring.kafka.consumer.group-id}")
  public void consumer(ConsumerRecord<String, Object> record) {
    inputPort.processNotification(record.value());
  }
}
