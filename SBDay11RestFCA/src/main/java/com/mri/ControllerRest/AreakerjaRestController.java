package com.mri.ControllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mri.models.Areakerja;
import com.mri.services.AreakerjaService;


@RestController
@RequestMapping("api/v1/areakerja")
public class AreakerjaRestController {
	
	@Autowired
	private AreakerjaService as;
	
	@GetMapping(value = "listall")
	public List<Areakerja>listall(){
		return as.listall();
	}
}
