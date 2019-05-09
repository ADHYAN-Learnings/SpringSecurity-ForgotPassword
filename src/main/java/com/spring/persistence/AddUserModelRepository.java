package com.spring.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.AddUserModel;

public interface AddUserModelRepository extends JpaRepository<AddUserModel,Long> {
	AddUserModel findByEmail(String email);
	
}
