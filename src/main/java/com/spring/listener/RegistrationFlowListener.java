package com.spring.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.spring.model.RegistrationFlow;
import com.spring.model.RegistrationFlowCompleteEvent;
import com.spring.service.InterfRegistrationSaveService;

@Component
public class RegistrationFlowListener implements ApplicationListener<RegistrationFlowCompleteEvent> {

	@Autowired
	private InterfRegistrationSaveService registrationSaveService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment environment;
	
	@Override
	public void onApplicationEvent(final RegistrationFlowCompleteEvent event) {
		this.confirmRegistration(event);
	}
	private void confirmRegistration(final RegistrationFlowCompleteEvent event) {
		final RegistrationFlow registrationFlow = event.getRegistrationFlow();
		final String token = UUID.randomUUID().toString();
		registrationSaveService.createVerificationToken(registrationFlow, token);
		
		final SimpleMailMessage email = constructEmailMessage(event,registrationFlow,token);
		javaMailSender.send(email);
	}

	private SimpleMailMessage constructEmailMessage(final RegistrationFlowCompleteEvent event,
			final RegistrationFlow registrationFlow,final String token) {
		final String recipientAddress = registrationFlow.getEmail();
		final String subject = "Registration Confirmation";
		final String confirmationUrl = event.getAppUrl() +"/registrationConfirmation?token="+token;
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText("Please open the following url to  open your account: \r\n" +confirmationUrl);
        email.setFrom(environment.getProperty("support.email"));
		return email;
	}

}
