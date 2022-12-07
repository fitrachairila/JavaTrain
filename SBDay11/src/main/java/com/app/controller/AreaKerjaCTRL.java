package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.AreakerjaModel;
import com.app.service.AreaKerjaServ;

@RestController
@RequestMapping("api/v1/areakerja")
public class AreaKerjaCTRL {
	
	@Autowired
	private AreaKerjaServ as;
	
	@GetMapping(value="listall")
	public List<AreakerjaModel> listall (){
		return as.listall();
	}

}




