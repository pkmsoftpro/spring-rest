package com.complex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Runner {
	public static void main(String[] args) {
		System.out.println("inside Main.Runner");		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		
		NotificationService notificationService = context.getBean(NotificationService.class);
		notificationService.sendNotification("abc.abc@abc.com", "test message");
		
		
		context.close();
	}
}
