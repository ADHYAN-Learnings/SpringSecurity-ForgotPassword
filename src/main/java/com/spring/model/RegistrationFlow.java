package com.spring.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import com.spring.customAnnotation.PasswordRepeaterCheck;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Transient;

@Entity
@PasswordRepeaterCheck
public class RegistrationFlow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long RegistrationId;
	
	@Email
	@NotNull(message="Email Id is Required")
	@NotEmpty(message="Email Id is required.")
	private String email;
	
	@NotNull(message="Password is Required.")
	@NotEmpty(message="Password is Required.")
	private String password;
	
	@Transient
	@NotNull(message="Password Confirmation is Required.")
	@NotEmpty(message="Password Confirmation is Required.")
	private String passwordConfirmation;
	
	@Column
	private Boolean enabled;
	
	private Calendar created = Calendar.getInstance();

	public Long getRegistrationId() {
		return RegistrationId;
	}

	public void setRegistrationId(Long registrationId) {
		RegistrationId = registrationId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "RegistrationFlow [RegistrationId=" + RegistrationId + ", email=" + email + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + ", enabled=" + enabled + ", created=" + created
				+ "]";
	}
}
