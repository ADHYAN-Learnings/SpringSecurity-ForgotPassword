package com.spring.customAnnotationValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.spring.customAnnotation.PasswordRepeaterCheck;
import com.spring.model.RegistrationFlow;

public class PasswordRepeaterCheckValidator implements ConstraintValidator<PasswordRepeaterCheck,Object> {

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		RegistrationFlow registrationFlow = (RegistrationFlow)object;
		return registrationFlow.getPassword().equals(registrationFlow.getPasswordConfirmation());
	}

}
