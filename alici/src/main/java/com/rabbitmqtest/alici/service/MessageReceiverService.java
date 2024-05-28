package com.rabbitmqtest.alici.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmqtest.alici.dto.MessageDto;

import lombok.extern.slf4j.Slf4j;

@Service
@RabbitListener(queues = "${rabbitmq.queue}", id = "listener")
@Slf4j
public class MessageReceiverService {

    @RabbitHandler
    public void receiver(MessageDto messageDto) {
        log.info(
                messageDto.getMessage() + " mesajını " + messageDto.getTo()
                        + "na gönderiliyor.");
    }

    // @RabbitHandler
    // public void receiver(Object messageDto) {
    // log.info("Ayrıca object olarak yakalamak istersek burada bu şekilde
    // yapabiliyoruz " +
    // messageDto.toString());
    // }
}
