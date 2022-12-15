package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/default")
public class DefaultCTRL {

	//21fe33a8-4c7d-4425-87d3-2cd9887d9e06
	@GetMapping("list")
	public String list() {
		return "data list";
	}
	
	@GetMapping("add")
	public String add() {
		return "data add";
	}
	
	@GetMapping("del")
	public String del() {
		return "data del";
	}
	
	
	
}
