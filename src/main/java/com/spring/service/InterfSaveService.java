package com.spring.service;

import java.util.List;

import com.spring.model.AddUserModel;
import com.spring.model.RegistrationFlow;

public interface InterfSaveService {
     
	AddUserModel saveModel(AddUserModel addUserModel);
	
	List<AddUserModel> getUserDetails();
	
	void deleteUser(Long id);
	
	
}
