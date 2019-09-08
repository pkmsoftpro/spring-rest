package com.complex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.complex.email.EmailService;

@Service
//@Component
public class NotificationService {
	
//	@Autowired(required = false)
	private EmailService emailService;
	
	//constructor based DI
	//@Autowired
//	public NotificationService(EmailService emailService) {
//		this.emailService = emailService;
//	}

	public void sendNotification(String to, String msg) {
		emailService.sendEmail(to, msg);
	}

	//setter based DI
	@Autowired(required = false)
	@Qualifier("awsEmail")
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
}
