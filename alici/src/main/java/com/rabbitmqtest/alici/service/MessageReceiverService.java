package com.rabbitmqtest.alici.service;

import javax.swing.JOptionPane;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmqtest.alici.dto.MessageDto;

@Service
@RabbitListener(queues = "${rabbitmq.queue}", id = "listener")
public class MessageReceiverService {

    @RabbitHandler
    public void receiver(Object messageDto) {
        JOptionPane.showMessageDialog(null,
                ((MessageDto) messageDto).getMessage() + " mesajını " + ((MessageDto) messageDto).getTo()
                        + "na gönderiliyor.");
    }
}
