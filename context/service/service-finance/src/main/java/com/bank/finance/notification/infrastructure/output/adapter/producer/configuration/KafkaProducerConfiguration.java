package com.bank.finance.notification.infrastructure.output.adapter.producer.configuration;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaProducerConfiguration {
  private final KafkaProperties kafkaProperties;

  @Bean
  public ProducerFactory<String, Object> producerFactory() {
    return new DefaultKafkaProducerFactory<>(
        Map.of(
            BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers(),
            KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getProducer().getKeySerializer(),
            VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getProducer().getValueSerializer()));
  }

  @Bean
  public KafkaTemplate<String, Object> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}
