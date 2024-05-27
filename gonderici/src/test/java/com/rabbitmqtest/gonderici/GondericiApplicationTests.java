package com.rabbitmqtest.gonderici;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rabbitmqtest.gonderici.dto.MessageDto;
import com.rabbitmqtest.gonderici.service.MessageSenderService;

@SpringBootTest
class GondericiApplicationTests {
	@Autowired
	MessageSenderService senderService;

	@Test
	void contextLoads() {
		this.senderService.send(
				MessageDto.builder().message("Merhaba").to("blabla@gmail.com").build());
	}

}
