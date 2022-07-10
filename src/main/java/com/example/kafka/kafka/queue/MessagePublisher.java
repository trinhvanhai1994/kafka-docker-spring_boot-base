package com.example.kafka.kafka.queue;

public interface MessagePublisher {
    void publish(final String message);
}