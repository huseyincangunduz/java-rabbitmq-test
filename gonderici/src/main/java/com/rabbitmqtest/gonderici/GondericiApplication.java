package com.rabbitmqtest.gonderici;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.class })
public class GondericiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GondericiApplication.class, args);
	}

}
