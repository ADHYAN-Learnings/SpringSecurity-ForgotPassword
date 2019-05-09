package com.spring.service;

import com.spring.Exception.EmailExistsException;
import com.spring.model.PasswordResetToken;
import com.spring.model.RegistrationFlow;
import com.spring.model.VerificationToken;

public interface InterfRegistrationSaveService {
	
  RegistrationFlow save(RegistrationFlow registrationFlow) throws EmailExistsException;
  
  void createVerificationToken(RegistrationFlow registrationFlow,String token);
  
  VerificationToken getVerificationToken(String token);
  
  void saveRegisteredUser(RegistrationFlow registrationFlow);
  
	
  RegistrationFlow findUserByEmail(String email);
	
  void createPasswordResetToken(RegistrationFlow user,String token);
  
  PasswordResetToken getPasswordResetToken(String token);
  
  void changePassword(RegistrationFlow user,String password);
}
