package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.UserSendMail;
import com.example.demo.services.MailService;



@RequestMapping("/api/mail")
@RestController
public class MailController {
	
	@Autowired
	private MailService notificationService;

	@Autowired
	private UserSendMail user;
	@PostMapping("/send-mail")
	public String send( @RequestBody UserSendMail user1) {

		/*
		 * Creating a User with the help of User class that we have declared. Setting
		 * the First,Last and Email address of the sender.
		 */
		user.setFirstName(user1.getFirstName());
		user.setLastName(user1.getLastName());
		user.setEmailAddress(user1.getEmailAddress()); //Receiver's email address

		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}


}