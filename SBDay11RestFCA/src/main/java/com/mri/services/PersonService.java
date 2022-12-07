package com.mri.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mri.models.Person;
import com.mri.repo.PersonRepo;

@Service
@Transactional
public class PersonService {
	
	@Autowired
	private PersonRepo pr;
	
	public List<Person>listall(){
		return pr.findAll();
	}
}
