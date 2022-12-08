package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.AreakerjaModel;
import com.app.repo.AreaKerjaRepo;

@Service
@Transactional
public class AreaKerjaServ {

	@Autowired
	private AreaKerjaRepo ar;
	
	public List<AreakerjaModel>listall(){
		return ar.findAll();
	}
}
