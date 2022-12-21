package com.app.RestControl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Passengers;
import com.app.service.PassengersServ;

@RestController
@RequestMapping("api/psg/")
public class PassenggersCTRL {

	@Autowired
	private PassengersServ ps;
	
	@GetMapping("list")
	public List<Passengers>list() {
		return ps.list();
	}
}
