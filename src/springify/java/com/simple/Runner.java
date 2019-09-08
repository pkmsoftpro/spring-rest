package com.simple;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Runner {
	public static void main(String[] args) {
		System.out.println("inside Main.Runner");
		
		/*
		 * HelloMsg msg1 = new HelloMsg(1); msg1.printMsg(); HelloMsg msg2 = new
		 * HelloMsg(2); msg2.printMsg();
		 */
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		HelloMsg hmBean = context.getBean(HelloMsg.class, new Integer(2));
		
		hmBean.printMsg();
		
		
		
		
		
		context.close();
	}
}
