package com.rabbitmqtest.alici;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.class })
public class AliciApplication {

	public static void main(String[] args) {
		SpringApplication.run(AliciApplication.class, args);
	}

}
