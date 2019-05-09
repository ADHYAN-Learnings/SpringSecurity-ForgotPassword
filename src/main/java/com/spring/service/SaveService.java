package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.AddUserModel;
import com.spring.model.PasswordResetToken;
import com.spring.model.RegistrationFlow;
import com.spring.persistence.AddUserModelRepository;
import com.spring.persistence.PasswordResetTokenRepository;

@Service
@Transactional
public class SaveService implements InterfSaveService {
	
	
	@Autowired
	private AddUserModelRepository addUserModelRepository;
	

	@Override
	public AddUserModel saveModel(AddUserModel addUserModel) {
		return addUserModelRepository.save(addUserModel);
	}

	@Override
	public List<AddUserModel> getUserDetails() {
		return addUserModelRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		 addUserModelRepository.deleteById(id);
	}

}
