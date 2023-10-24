package com.kwingi.emailsmicroservice.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kwingi.emailsmicroservice.dtos.EmailRecordDTO;
import com.kwingi.emailsmicroservice.services.EmailService;

@Component
public class EmailConsumer {
	
	@Autowired private ObjectMapper mapper;
	
	@Autowired private EmailService emailService;
	
	@RabbitListener(queues = "${mbroker.queue.email}")
	public void listenEmailQueue(String payload) {
		try {
			EmailRecordDTO email = mapper.readValue(payload, EmailRecordDTO.class);
			emailService.sendEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

}
