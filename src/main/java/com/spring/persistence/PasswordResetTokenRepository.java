package com.spring.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long> {
	
  PasswordResetToken findByToken(String token);
  
}
