package com.simple;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") 
public class HelloMsg {
	
	int i;
	
	public HelloMsg() {
		super();
		this.i=1;
	}

	public HelloMsg(int i) {
		super();
		this.i = i;
	}

	public void printMsg() {
		System.out.println("inside HelloMsg" + i);
	}
}
