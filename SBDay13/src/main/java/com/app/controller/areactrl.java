package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.areamodel;
import com.app.service.areaserv;

@RestController
@RequestMapping(value = "api/area/")
public class areactrl {
	@Autowired
	private areaserv ps;
	
	@GetMapping(value ="listall")
	public List<areamodel> listall(){
		return ps.listall();
	}
}

