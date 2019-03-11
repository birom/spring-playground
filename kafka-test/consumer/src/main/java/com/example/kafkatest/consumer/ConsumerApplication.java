package com.example.kafkatest.consumer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ConsumerApplication {
    private static Logger LOG = LoggerFactory.getLogger(ConsumerApplication.class);

    private CountDownLatch countDownLatch = new CountDownLatch(500);

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @KafkaListener(topics = "test-topic")
    public void listen(ConsumerRecord<?, ?> record) throws Exception {
        LOG.info("Message received: {}", record.value());

        if (countDownLatch.getCount() > 0) {
            countDownLatch.await(610, TimeUnit.MILLISECONDS);
            countDownLatch.countDown();
        }
    }
}
