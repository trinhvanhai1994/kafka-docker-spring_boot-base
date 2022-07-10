package com.example.kafka.kafka.controller;

import com.example.kafka.kafka.queue.RedisMessagePublisher;
import com.example.kafka.kafka.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;
    private final RedisMessagePublisher publish;

    @Autowired
    KafkaController(Producer producer, RedisMessagePublisher publish) {
        this.producer = producer;
        this.publish = publish;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {

        this.producer.sendMessage(message);

//        publish.publish(message);
    }
}