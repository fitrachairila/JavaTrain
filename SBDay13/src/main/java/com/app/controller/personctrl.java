package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.DTOperson;
import com.app.model.personmodel;
import com.app.service.personserv;

@RestController
@RequestMapping(value = "api/person/")
public class personctrl {

	@Autowired
	private personserv ps;

	@GetMapping(value = "listall")
	public List<personmodel> listall() {
		return ps.listall();
	}

	@GetMapping(value = "personarea")
	public List<Map<String, Object>> personarea() {
		return ps.personarea();
	}

	@GetMapping(value = "listperson")
	public List<Map<String, Object>> listperson() {
		return ps.listperson();
	}
	@GetMapping(value = "listperson2")
	public List<DTOperson> listperson2() {
		return ps.listperson2();
	}
}