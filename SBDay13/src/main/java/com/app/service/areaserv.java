package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.areamodel;
import com.app.repo.arearepo;

@Service
@Transactional
public class areaserv {
	@Autowired
	private arearepo ar;
	
	public List<areamodel> listall() {
		return ar.findAll();
		} 
}
