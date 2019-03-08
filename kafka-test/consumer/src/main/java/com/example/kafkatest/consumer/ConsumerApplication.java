package com.example.kafkatest.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ConsumerApplication {
    private static Logger LOG = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @KafkaListener(topics = "test-topic")
    public void listen(ConsumerRecord<?, ?> record) throws Exception {
        LOG.info("Message received: {}", record.value());
        Thread.sleep(610);
    }
}
