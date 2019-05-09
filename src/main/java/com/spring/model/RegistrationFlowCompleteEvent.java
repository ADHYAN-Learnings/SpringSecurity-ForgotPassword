package com.spring.model;

import org.springframework.context.ApplicationEvent;

public class RegistrationFlowCompleteEvent extends ApplicationEvent {
	
	
	private final String appUrl;
	private final RegistrationFlow registrationFlow;
	
	public RegistrationFlowCompleteEvent(final RegistrationFlow registrationFlow , final String appUrl) {
		super(registrationFlow);
		this.appUrl = appUrl;
		this.registrationFlow = registrationFlow;
	}

	 public String getAppUrl() {
		 return appUrl;
	 }
	 
	 public RegistrationFlow getRegistrationFlow() {
		 return registrationFlow;
	 }

}
