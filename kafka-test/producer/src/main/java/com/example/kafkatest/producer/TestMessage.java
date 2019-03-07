package com.example.kafkatest.producer;

public class TestMessage {
    private String message;

    public TestMessage() {
    }

    public TestMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public TestMessage setMessage(String message) {
        this.message = message;
        return this;
    }
}
