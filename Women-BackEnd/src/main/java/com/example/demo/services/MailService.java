package com.example.demo.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserSendMail;

@Service
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(UserSendMail user) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */
		
		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo(user.getEmailAddress());
		mail.setTo("drihmihaythem@gmail.com");
		System.out.println(mail.getTo());
		mail.setSubject("Pi");
		mail.setText("Java spring boot Project Women empowerment");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		this.javaMailSender.send(mail);
		System.out.println(mail.getSentDate());
		
	}
}
