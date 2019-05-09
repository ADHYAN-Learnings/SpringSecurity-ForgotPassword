package com.spring.customAnnotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.customAnnotationValidator.PasswordRepeaterCheckValidator;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {PasswordRepeaterCheckValidator.class})
public @interface PasswordRepeaterCheck {
	
	String message() default "Passwords do not match";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
