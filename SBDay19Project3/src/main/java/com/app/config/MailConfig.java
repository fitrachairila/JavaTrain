package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailConfig {

	@Autowired
	JavaMailSender javaMailSender;
	
	public void send(String to, String subject, String body) {
		
		//Isi Parameter Email
		SimpleMailMessage messages = new SimpleMailMessage();
		messages.setTo(to);
		messages.setSubject(subject);
		messages.setText(body);

		// kirim email by javamailsender
		javaMailSender.send(messages);
	}
}