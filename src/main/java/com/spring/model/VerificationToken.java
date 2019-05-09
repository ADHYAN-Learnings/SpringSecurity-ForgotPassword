package com.spring.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class VerificationToken {
	
	private static final int EXPIRATION  = 60*24;
	
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String token;
	
	@OneToOne(targetEntity = RegistrationFlow.class , fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,name="user_Id")
	private RegistrationFlow registrationFlow;
	
	private Date expiryDate;
	
	public VerificationToken() {
		super();
	}
	
	public VerificationToken(String token) {
		super();
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}
	
	public VerificationToken(final String token , final RegistrationFlow registrationFlow) {
		super();
		
		this.token = token;
		this.registrationFlow = registrationFlow;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}
	
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public RegistrationFlow getRegistrationFlow() {
		return registrationFlow;
	}

	public void setRegistrationFlow(RegistrationFlow registrationFlow) {
		this.registrationFlow = registrationFlow;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(calendar.getTime().getTime());
	}
	
	public void updateToken(final String token) {
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

}
