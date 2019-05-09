package com.spring.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    
	VerificationToken findByToken(String token);
}
