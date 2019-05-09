package com.spring.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.RegistrationFlow;

public interface RegistrationFlowRepository extends JpaRepository<RegistrationFlow,Long> {

	RegistrationFlow findByEmail(String email);
}
