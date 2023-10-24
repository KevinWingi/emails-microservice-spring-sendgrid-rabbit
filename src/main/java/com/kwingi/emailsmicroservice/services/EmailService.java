package com.kwingi.emailsmicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kwingi.emailsmicroservice.dtos.EmailRecordDTO;

@Service
public class EmailService {
	
	@Autowired private JavaMailSender mailSender;
	
	@Value("${spring.mail.from}")
	private String from;
	
	public void sendEmail(EmailRecordDTO dto) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(from);
		email.setSubject(dto.subject());
		email.setText(dto.content());
		
		if (dto.tos() != null && !dto.tos().isEmpty()) email.setTo(dto.tos().toArray(new String[0]));
		if (dto.ccs() != null && !dto.ccs().isEmpty()) email.setCc(dto.ccs().toArray(new String[0]));
		if (dto.bccs() != null && !dto.bccs().isEmpty()) email.setBcc(dto.bccs().toArray(new String[0]));	
				
		mailSender.send(email);
	}
	
}
