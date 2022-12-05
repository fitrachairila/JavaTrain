package com.mri.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mri.models.UserModel;
import com.mri.repositorys.UserRepo;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepo ur;
	
	public List<UserModel> logon(String users, String password) {
		return ur.logon(users, password);
	}
}
