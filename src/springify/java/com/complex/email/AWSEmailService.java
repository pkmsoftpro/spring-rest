package com.complex.email;

import org.springframework.stereotype.Component;

@Component("awsEmail")
public class AWSEmailService implements EmailService{

	@Override
	public void sendEmail(String toAddr, String msg) {
		System.out.println("Send email to:" + toAddr + "; Msg:" + msg);		
	}

}
