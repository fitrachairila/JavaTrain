package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Repo.mailisrepo;
import com.app.model.Mailisimodel;

@Service
@Transactional
public class MailisServ {

	@Autowired
	private mailisrepo mr;
	
	public List<Mailisimodel>isipesan(){
		return mr.findAll();
	}

}