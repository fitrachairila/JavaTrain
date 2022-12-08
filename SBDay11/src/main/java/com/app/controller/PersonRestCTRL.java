package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.PersonModel;
import com.app.service.PersonServ;

@RestController
@RequestMapping("api/v1/person")
public class PersonRestCTRL {
		
	@Autowired
	private PersonServ ps;
	
	@GetMapping(value = "listall")
	public List<PersonModel>listall(){
		return ps.listall();
	}
}