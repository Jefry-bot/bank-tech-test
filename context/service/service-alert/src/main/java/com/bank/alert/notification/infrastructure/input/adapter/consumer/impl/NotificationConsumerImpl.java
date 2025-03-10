package com.bank.alert.notification.infrastructure.input.adapter.consumer.impl;

import com.bank.alert.notification.application.input.port.NotificationInputPort;
import com.bank.alert.notification.infrastructure.input.adapter.consumer.configuration.Consumer;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Consumer
@RequiredArgsConstructor
public class NotificationConsumerImpl {

  private final NotificationInputPort inputPort;

  @KafkaListener(
      topics = "${spring.kafka.template.default-topic}",
      groupId = "${spring.kafka.consumer.group-id}")
  public void consumer(ConsumerRecord<String, Map<String, Object>> consumerRecord) {
    inputPort.clientProcessNotification(consumerRecord.value());
  }
}
