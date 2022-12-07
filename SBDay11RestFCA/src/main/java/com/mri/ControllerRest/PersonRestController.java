package com.mri.ControllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mri.models.Person;
import com.mri.services.PersonService;

@RestController
@RequestMapping("api/v1/person")
public class PersonRestController {
	
	@Autowired
	private PersonService ps;
	
	@GetMapping(value = "listall")
	public List<Person>listall(){
		return ps.listall();
	}
}
