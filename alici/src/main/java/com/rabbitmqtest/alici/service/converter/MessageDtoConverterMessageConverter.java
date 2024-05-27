package com.rabbitmqtest.alici.service.converter;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;

import com.rabbitmqtest.alici.dto.MessageDto;

public class MessageDtoConverterMessageConverter implements MessageConverter {

    private static final String TYPE_ID = "__TypeId__";
    private MessageConverter delegateConverter;

    public MessageDtoConverterMessageConverter() {
        this.delegateConverter = new SimpleMessageConverter(); // Varsayılan dönüştürücüyü kullanabilirsiniz.
    }

    @Override
    public Object fromMessage(Message message) {
        // Gelen mesajdaki sınıf ismini dönüştürün
        String body = new String(message.getBody());
        Object incomingClass = message.getMessageProperties().getHeaders().get(TYPE_ID);
        if (incomingClass.equals("com.rabbitmqtest.gonderici.dto.MessageDto")) {
            message.getMessageProperties().getHeaders().put(TYPE_ID, MessageDto.class.getPackageName());
        }

        return delegateConverter.fromMessage(message);

        // message.getMessageProperties().setReceivedMessageType(newClassName);

        // Delegated converter kullanarak mesajı işleyin
    }

    @Override
    public Message toMessage(Object object, org.springframework.amqp.core.MessageProperties messageProperties) {
        // Dönüştürme işlemleri...
        return delegateConverter.toMessage(object, messageProperties);
    }
}
