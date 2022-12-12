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
		
		SimpleMailMessage isipesan = new SimpleMailMessage();
		isipesan.setTo(to);
		isipesan.setSubject(subject);
		isipesan.setText(body);
		
		//kirim email by javamailsender
		javaMailSender.send(isipesan);
	}
}
