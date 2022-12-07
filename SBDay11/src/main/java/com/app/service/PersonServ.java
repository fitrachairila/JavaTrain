package com.app.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.PersonModel;
import com.app.repo.PersonRepo;

@Service
@Transactional
public class PersonServ {

		@Autowired
		private PersonRepo pr;
		
		public List<PersonModel>listall(){
			return pr.findAll();
		}
	}