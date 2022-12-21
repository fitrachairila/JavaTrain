package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Passengers;
import com.app.repository.PassengersRepo;

@Service
public class PassengersServ {

	@Autowired
	private PassengersRepo pr;
	
	public List<Passengers>list() {
		return pr.findAll();
	}
}
