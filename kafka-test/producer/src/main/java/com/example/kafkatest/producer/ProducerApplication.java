package com.example.kafkatest.producer;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(ProducerApplication.class);

    private KafkaTemplate kafkaTemplate;

    public ProducerApplication(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Executing kafka producer.");

        IntStream.range(0, 1_000_000)
            .mapToObj(i -> String.format("num-%d", i))
            .map(TestMessage::new)
            .forEach(this::doSend);
    }

    private void doSend(Object message) {
        this.kafkaTemplate.send("test-topic", message);
    }
}
