package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;

@Entity
public class AddUserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;	
     
	@NotNull(message="First Name is Required.")
	@NotEmpty(message="First Name is Required.")
	private String firstName;
	
	@NotNull(message="Last Name is Required.")
	@NotEmpty(message="Last Name is Required.")
	private String lastName;
	
	@Email
	@NotNull(message="Email is Required.")
	@NotEmpty(message="Email is Required.")
	private String email;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AddUserModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	

}
