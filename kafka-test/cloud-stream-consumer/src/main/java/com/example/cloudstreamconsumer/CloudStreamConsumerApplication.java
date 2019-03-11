package com.example.cloudstreamconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CloudStreamConsumerApplication {

    private static Logger LOG = LoggerFactory.getLogger(CloudStreamConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumerApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void messageListener(Message<?> message) throws Exception {
        LOG.info("Message received: {}", message.getPayload());
        Thread.sleep(610);
    }
}
