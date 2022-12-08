package com.app.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.model.DTOperson;
import com.app.model.personmodel;
import com.app.repo.personrepo;

@Service
@Transactional
public class personserv {
	
	@Autowired
	private personrepo pr;
	
	public List<personmodel> listall() {
	return pr.findAll();
	} 
	
	public List<Map<String, Object>>listperson(){
		return pr.listperson();
	}
	
	public List<DTOperson>listperson2(){
		return pr.listperson2();
	}
	
	public List<Map<String, Object>>personarea(){
		return pr.personarea();
}
}