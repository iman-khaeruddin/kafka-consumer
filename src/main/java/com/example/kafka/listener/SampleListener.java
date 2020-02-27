package com.example.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.model.User;

@Service
public class SampleListener {

    /**
     * This listener for consume from topic2. Consume string message.
     * */
	@KafkaListener(topics = "topic2", groupId = "group_id")
	public void Consume(String message) {
		System.out.println("consume message :" + message);
	}

    /**
     * This listener for consume from topic1. Consume json message.
     * */
    @KafkaListener(topics = "topic1", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}
