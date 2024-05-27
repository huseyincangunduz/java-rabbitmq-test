package com.rabbitmqtest.gonderici.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmqtest.gonderici.dto.MessageDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageSenderService {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    public void send(MessageDto message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}