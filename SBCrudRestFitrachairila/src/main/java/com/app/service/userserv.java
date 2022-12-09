package com.app.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.usermodel;
import com.app.repo.userrepo;

@Service
@Transactional
public class userserv {

	@Autowired
	private userrepo ur;
	
	public List<usermodel> userlist(String users, String password){
		return ur.userlist(users, password);
	}
}
